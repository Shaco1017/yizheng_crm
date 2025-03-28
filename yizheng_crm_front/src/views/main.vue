<script>
import AsideMenu from '../components/AsideMenu.vue';
import router from '../router';
import CommonHeader from '../components/CommonHeader.vue';
import CommonTag from '../components/CommonTag.vue';
export default {
    name: 'Main',
    data() {
        return {
            msg: 'Welcome to Your Vue.js App'
        }
    }, components: {
        AsideMenu,
        CommonHeader,
        CommonTag
    }
}
</script>
<template>
    <div class="main">
        <el-container>
            <el-aside width="auto">
                <Aside-Menu></Aside-Menu>
            </el-aside>
            <el-container>
                <el-header>
                    <CommonHeader></CommonHeader>
                    <!-- <router-view></router-view> -->
                </el-header>
                <Common-Tag></Common-Tag>
                <el-main><router-view></router-view></el-main>
                <!-- <el-footer>123</el-footer> -->
            </el-container>
        </el-container>
    </div>
</template>
<style lang="less" scoped>
.el-header {
    padding: 0;
}

// .el-aside {
//     height: flex;
//     background-color: #D3DCE6;
//     color: #333;
//     text-align: center;
//     line-height: 60px;
// }</style>
<!-- <style scoped>
.el-header,
.el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
}

.el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    /* line-height: 60px; */
    
}

.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
}
</style> -->