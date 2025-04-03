<template>
    <div class="mod-role">
        <el-form :inline="true" :model="dataForm">
            <el-form-item>
                <el-input v-model="dataForm.roleName" placeholder="角色名称" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="getDataList()">查询</el-button>
                <el-button type="primary">新增</el-button>
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
                    <el-button type="text" size="small" @click="deleteHandle(scope.row.roleId)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
            :page-sizes="[5, 10, 20, 50, 100]" :page-size="length" :total="totalPage"
            layout="total, sizes, prev, pager, next, jumper" style="margin-top:30px;">
        </el-pagination>
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
        };
    },
    methods: {
        // 获取数据列表
        getDataList() {
            // 提交的参数
            const params = {
                params: {
                    pageIndex: this.pageIndex,
                    length: this.length,
                    roleName: this.dataForm.roleName,
                },
            };
            this.dataListLoading = true;
            this.$http.get("/sys/sysRole/queryPage", params).then(({ data }) => {
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
            this.pageIndex = 1;
            this.getDataList();
        },
        // 当前页
        currentChangeHandle(val) {
            this.pageIndex = val;
            this.getDataList();
        },
    }, mounted() {
        this.getDataList()
    },
};
</script>
<style lang="less" scoped></style>