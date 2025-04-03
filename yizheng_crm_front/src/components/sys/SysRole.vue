<template>
    <div class="mod-role">
        <el-form :inline="true" :model="dataForm">
            <el-form-item>
                <el-input v-model="dataForm.roleName" placeholder="角色名称" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="getDataList()">查询</el-button>
                <el-button type="primary" @click="openaddDialog()">新增</el-button>
            </el-form-item>
        </el-form>
        <el-table :data="dataList" border v-loading="dataListLoading" style="width: 100%">
            <el-table-column type="selection" header-align="center" align="center" width="50">
            </el-table-column>
            <el-table-column prop="roleId" header-align="center" align="center" width="80" label="ID">
            </el-table-column>
            <el-table-column prop="roleName" header-align="center" align="center" label="角色名称">
            </el-table-column>
            <el-table-column prop="remark" header-align="center" align="center" label="备注">
            </el-table-column>
            <el-table-column prop="createTime" header-align="center" align="center" width="180" label="创建时间">
            </el-table-column>
            <el-table-column fixed="right" header-align="center" align="center" width="150" label="操作">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.roleId)">修改</el-button>
                    <el-button type="text" size="small" @click="handleDelete(scope.row.roleId)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
            :page-sizes="[5, 10, 20, 50, 100]" :page-size="length" :total="totalPage"
            layout="total, sizes, prev, pager, next, jumper" style="margin-top:30px;">
        </el-pagination>
        <!-- Form -->
        <!-- <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button> -->

        <el-dialog title="新增角色" width="35%" :visible.sync="add_dialog_FormVisible">
            <el-form :model="dataDialogForm" :rules="rules" ref="ruleForm">
                <el-form-item label="角色名称" label-width="120px" prop="roleName">
                    <el-input v-model="dataDialogForm.roleName" placeholder="角色名称" style="width: 300px"></el-input>
                </el-form-item>
                <el-form-item label="描述信息" label-width="120px" prop="remark">
                    <el-input type="textarea" v-model="dataDialogForm.remark" style="width: 300px"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleSubmitFormData('ruleForm')">确 定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="update角色" width="35%" :visible.sync="update_dialog_FormVisible">
            <el-form :model="dataDialogForm" :rules="rules" ref="ruleForm">
                <el-form-item label="角色名称" label-width="120px" prop="roleName">
                    <el-input v-model="dataDialogForm.roleName" placeholder="角色名称" style="width: 300px"></el-input>
                </el-form-item>
                <el-form-item label="描述信息" label-width="120px" prop="remark">
                    <el-input type="textarea" v-model="dataDialogForm.remark" style="width: 300px"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleSubmitFormData('ruleForm')">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
export default {
    name: "sysRole",
    data() {
        return {
            dataForm: {
                roleName: "",
            },
            dataList: [],
            pageIndex: 1,
            length: 5,
            totalPage: 0,
            dataListLoading: false,

            add_dialog_FormVisible: false,
            dataDialogForm: {


                // name: '',
                // region: '',
                // date1: '',
                // date2: '',
                // delivery: false,
                // type: [],
                // resource: '',
                // desc: ''
            },
            rules: {
                // roleName
            },
            // dia

            update_dialog_FormVisible: false,

        };
    },
    methods: {
        // 获取数据列表
        getDataList() {
            // 提交的参数

            const params = {
                params: {
                    pageIndex: this.pageIndex,
                    pageSize: this.length,
                    roleName: this.dataForm.roleName,
                },
            };
            console.log(params)
            this.dataListLoading = true;
            this.$http.get("/sys/sysRole/list", params).then(({ data }) => {
                if (data && data.code === "SUCCESS") {
                    this.dataList = data.data.list;
                    this.totalPage = data.data.totalCount;
                } else {
                    this.dataList = [];
                    this.totalPage = 0;
                }
                this.dataListLoading = false;
            });
        },
        // 每页数
        sizeChangeHandle(val) {
            this.length = val;
            // this.pageIndex = 1;
            this.getDataList();
        },
        // 当前页
        currentChangeHandle(val) {
            this.pageIndex = val;
            this.getDataList();
        },
        openaddDialog() {
            // 打开窗口
            this.dialogFormVisible = true;
        },
        handleSubmitFormData(formName) {
            this.addRole(formName);
        },
        addRole(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    if (this.dialogFormSubmitVisible) {
                        return;
                    }
                    this.dialogFormSubmitVisible = true;
                    this.$http
                        .post("/sys/sysRole/addUser", this.dataDialogForm)
                        .then((res) => {
                            console.log(res);
                            this.dialogFormVisible = false; // 关闭窗口
                            // 刷新数据
                            this.getDataList();
                        });
                } else {
                    // console.log('error submit!!');
                    return false;
                }
            });
        },
        handleDelete(index, item) {
            // 删除角色信息
            this.$confirm("此操作将永久该记录, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            })
                .then(() => {
                    if (this.dialogFormSubmitVisible) {
                        return;
                    }
                    this.dialogFormSubmitVisible = true;
                    this.$http
                        .get("/sys/sysRole/deleteRole?roleId=" + item.roleId)
                        .then((res) => {
                            console.log(res)
                            if (res.data.data === '0') {
                                // 表示数据不能被删除
                                this.$message({
                                    type: "warning",
                                    message: "该条记录不允许删除!",
                                });
                            } else {
                                this.$message({
                                    type: "success",
                                    message: "删除成功!",
                                });
                            }
                            this.dialogFormSubmitVisible = false;
                            // 刷新数据
                            this.getDataList();
                        });
                })
                .catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消删除",
                    });
                });
        }
    }, mounted() {
        this.getDataList()
    },
};
</script>
<style lang="less" scoped></style>