import Vue from 'vue'
import Router from 'vue-router'

import main from '../views/main.vue'
import Home from '@/components/Home.vue'
import CommonCustomer from '@/components/customer/CommonCustomer.vue'
import CustomerList from '@/components/customer/CustomerList.vue'
import AllOrder from '@/components/order/AllOrder.vue'
import MyOrder from '@/components/order/MyOrder.vue'
import Login from '../views/Login.vue'
import SyeRole from '../components/sys/SysRole.vue'
import SysMenu from '../components/sys/SysMenu.vue'
import SysUser from '../components/sys/SysUser.vue'

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/Login',
      name: "Login",
      component: Login
    },

    {
      path: '/',
      name: 'Main', // 主路由
      component: main,
      redirect: 'Home',
      children: [ // 子路由
        { // 添加对应的 路由映射关系
          path: 'Home',
          name: 'Home',
          component: Home
        }, {
          path: 'CommonCustomer',
          name: 'CommonCustomer',
          component: CommonCustomer
        }, {
          path: 'CustomerList',
          name: 'CustomerList',
          component: CustomerList
        }, {
          path: 'AllOrder',
          name: 'AllOrder',
          component: AllOrder
        }, {
          path: 'MyOrder',
          name: 'MyOrder',
          component: MyOrder
        },
      {
        path:'SysRole',
        component: SyeRole
      },
      {
        path:'SysMenu',
        component: SysMenu
      },
      {
        path:'SysUser',
        component: SysUser
      }]
    }
  ]

})

