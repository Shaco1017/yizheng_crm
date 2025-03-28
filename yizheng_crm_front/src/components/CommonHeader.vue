<template>
    <div class="header-container">
        <div class="l-content">

            <!-- <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                <el-breadcrumb-item>活动详情</el-breadcrumb-item>
            </el-breadcrumb> -->

            <el-button @click="handleMenu" icon="el-icon-menu" size="medium"></el-button>
            <!-- <span class="firstPage">首页</span> -->
            <el-breadcrumb separator="/">
                {{ tags }}
                <el-breadcrumb-item v-for="item in tags" :key="item.path" :to="{ path: item.path }">
                    {{ item.label }}
                </el-breadcrumb-item>
            </el-breadcrumb>

        </div>

        <div class="r-content">
            <el-dropdown>
                <span class="el-dropdown-link">
                    <img class="user_img" src="@/assets/images/user.jpg" />
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>个人信息</el-dropdown-item>
                    <el-dropdown-item>注销</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>
<script>
import { mapState } from 'vuex';
export default {
    name: 'Header',
    data() {
        return {
            msg: 'Welcome to Your Vue.js App'
        }
    },
    methods: {
        handleMenu() {
            this.$store.commit('collapseMenu')
        }

    },
    computed: {
        ...mapState({
            tags: state => state.tabsList
        })

    }
}
// 
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- <style lang="less" scoped>
    .header-container{
    background-color: #242f42;
    height: 70px;
    }
    </style> -->
<style lang="less" scoped>
.header-container {
    padding: 0 20px;
    background-color: #242f42;
    height: 70px;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .firstPage {
        color: #fff;
        font-size: 16px;
        margin-left: 10px;
    }

    .r-content {
        padding-right: 20px;

        .user_img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }
    }

}
</style>