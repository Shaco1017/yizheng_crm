<template>
    <div class="aside">

        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
            :collapse="isCollapse" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
            <!-- <h3>CRM</h3> -->
            <h3>{{ isCollapse ? 'C' : 'CRM' }}</h3>
            <!-- //console.log(item) -->
            <!-- 无子菜单 -->
            <el-menu-item @click="clickMenu(item)" v-for="item in dontHasChild" :key="item.name" :index="item.name">
                <i :class="`el-icon-${item.icon}`"></i>
                <span slot="title">{{ item.label }}</span>
            </el-menu-item>
            <el-submenu v-for="item in hasChild" :key="item.name" :index="item.name">
                <template slot="title">
                    <i :class="`el-icon-${item.icon}`"></i>
                    <span slot="title">{{ item.label }}</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item @click="clickMenu(subItem)" v-for="subItem in item.children" :key="subItem.name"
                        :index="subItem.name">{{ subItem.label }}</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
        </el-menu>
    </div>
</template>

<style lang="less" scoped>
.el-menu {
    height: 100vh;
    border-right: none;

    h3 {
        color: #fff;
        text-align: center;
        line-height: 48px;
        font-size: 16px;
        font-weight: 400;
    }

}
</style>

<script>
export default {
    name: 'asidemenu',
    data() {
        return {
            // isCollapse: false,
            menuData: [
                {
                    path: '/',
                    name: 'main',
                    label: '首页',
                    icon: 's-home',
                    url: '/main'
                },
                {
                    label: '客户管理',
                    icon: 'user',
                    name: 'customer',
                    children: [
                        {
                            path: '/customerList',
                            name: 'customerList',
                            label: '客户列表',
                            icon: 'setting',
                            url: 'customer/customerList'
                        },
                        {
                            path: '/CommonCustomer',
                            name: 'commonCustomer',
                            label: '公海客户',
                            icon: 'setting',
                            url: 'customer/CommonCustomer'
                        }
                    ]
                },
                {
                    label: '订单管理',
                    icon: 's-order',
                    name: 'order',
                    children: [
                        {
                            path: '/allOrder',
                            name: 'allOrder',
                            label: '全部订单',
                            icon: 'setting',
                            url: 'order/allOrder'
                        },
                        {
                            path: '/MyOrder',
                            name: 'myOrder',
                            label: '我的订单',
                            icon: 'setting',
                            url: 'order/myOrder'
                        }
                    ]
                }
            ]
        };
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        clickMenu(item) {
            // this.$router.push(item.path)
            // $route 当前路由 $router 路由实例
            if (this.$route.path !== item.path && !(this.$route.path === '/Home' &&
                item.path === '/')) {
                this.$router.push(item.path)
            }
            this.$store.commit("selectMenu", item)
            // this.$store.commit("selectMenu", item)
        }

    },
    computed: {
        hasChild() {
            return this.menuData.filter(item => item.children)
        },
        dontHasChild() {
            return this.menuData.filter(item => !item.children)
        },
        isCollapse() {
            return this.$store.state.tab.isCollapse
        }
    }
};
</script>
