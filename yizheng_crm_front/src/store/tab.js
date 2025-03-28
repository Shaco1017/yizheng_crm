export default {
    state: {
        isCollapse: false, // 控制菜单的状态
        tabsList: [
            {
                path: '/',
                name: 'main',
                label: '首页',
                icon: 's-home',
                url: 'main',
            }
        ]
    },
    mutations: {
        collapseMenu(state) {
            state.isCollapse = !state.isCollapse
        },
        // 更新面包屑的数据
        selectMenu(state, val) {
            if (val.name !== 'main') {
                // 查询 集合数据中 对应名称的数据的索引
                const index = state.tabsList.findIndex(item => item.name === val.name)
                if (index === -1) {
                    // 说明不存在
                    state.tabsList.push(val)
                }
            }
        },
        closeTag(state,val){
            const index = state.tabsList.findIndex(item => item.name === val.name)
            state.tabsList.splice(index,1)
        }
    }
}