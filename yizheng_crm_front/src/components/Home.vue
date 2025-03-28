<template>
    <div>
        <!-- <h1>Home</h1> -->
        <el-row>
            <el-col :span="8">
                <div class="grid-content bg-purple">
                    <el-card class="box-card" style="margin-top:20px">
                        <div class="user">
                            <img src="@/assets/images/user.jpg" />
                            <div class="userinfo">
                                <p class="name">巨型仙人掌</p>
                                <p class="access">超级管理员</p>
                            </div>
                        </div>
                        <div class="login-info">
                            <p>上次登录的时间:<span>{{ Date() }}</span></p>
                            <p>上次登录的地点:<span>地球</span></p>
                        </div>
                    </el-card>
                    <el-card style=" margin-top: 20px">
                        <!--统计图-->
                        <div ref="echarts3" style="height:300px;"></div>
                    </el-card>
                </div>
            </el-col>
            <el-col :span="16" style="padding-left: 20px">
                <div class="grid-content bg-purple-light">
                    <el-card style="margin-top: 20px">
                        <el-table :data="tableData" stripe style="width: 100%">
                            <el-table-column prop="date" label="日期"> </el-table-column>
                            <el-table-column prop="name" label="姓名"> </el-table-column>
                            <el-table-column prop="address" label="地址"> </el-table-column>
                        </el-table>
                    </el-card>

                    <el-card class="box-card system_bulletin" style="margin-top: 20px">
                        <div slot="header" class="system_title">
                            <span>系统公告</span>
                        </div>
                        <div v-for="item in systemData" :key="item.id" class="system_context item">
                            <div>{{ item.title }}</div>
                            <div><i :class="`el-icon-${item.icon}`"> {{ item.date }}</i></div>
                        </div>
                    </el-card>
                    <el-card style=" margin-top: 20px">
                        <!--统计图-->
                        <div ref="echarts1" style="height:300px;"></div>
                    </el-card>
                    <el-card style=" margin-top: 20px">
                        <!--统计图-->
                        <div ref="echarts2" style="height:300px;"></div>
                    </el-card>
                </div>
            </el-col>
            <!-- <el-col :span="16" style=" margin-top: auto padding-left: auto">
                <el-card class="box-card system_bulletin">
                    <div slot="header" class="system_title">
                        <span>系统公告</span>
                    </div>
                    <div v-for="item in systemData" :key="item.id" class="system_context item">
                        <div>{{ item.title }}</div>
                        <div><i :class="`el-icon-${item.icon}`"> {{ item.date }}</i></div>
                    </div>
                </el-card>
            </el-col> -->
        </el-row>
    </div>
</template>
<script>
import * as echarts from 'echarts';
var data = [
            [
                [28604, 77, 17096869, "Australia", 1990],
                [31163, 77.4, 27662440, "Canada", 1990],
                [1516, 68, 1154605773, "China", 1990],
                [13670, 74.7, 10582082, "Cuba", 1990],
                [28599, 75, 4986705, "Finland", 1990],
                [29476, 77.1, 56943299, "France", 1990],
                [31476, 75.4, 78958237, "Germany", 1990],
                [28666, 78.1, 254830, "Iceland", 1990],
                [1777, 57.7, 870601776, "India", 1990],
                [29550, 79.1, 122249285, "Japan", 1990],
                [2076, 67.9, 20194354, "North Korea", 1990],
                [12087, 72, 42972254, "South Korea", 1990],
                [24021, 75.4, 3397534, "New Zealand", 1990],
                [43296, 76.8, 4240375, "Norway", 1990],
                [10088, 70.8, 38195258, "Poland", 1990],
                [19349, 69.6, 147568552, "Russia", 1990],
                [10670, 67.3, 53994605, "Turkey", 1990],
                [26424, 75.7, 57110117, "United Kingdom", 1990],
                [37062, 75.4, 252847810, "United States", 1990],
            ],
            [
                [44056, 81.8, 23968973, "Australia", 2015],
                [43294, 81.7, 35939927, "Canada", 2015],
                [13334, 76.9, 1376048943, "China", 2015],
                [21291, 78.5, 11389562, "Cuba", 2015],
                [38923, 80.8, 5503457, "Finland", 2015],
                [37599, 81.9, 64395345, "France", 2015],
                [44053, 81.1, 80688545, "Germany", 2015],
                [42182, 82.8, 329425, "Iceland", 2015],
                [5903, 66.8, 1311050527, "India", 2015],
                [36162, 83.5, 126573481, "Japan", 2015],
                [1390, 71.4, 25155317, "North Korea", 2015],
                [34644, 80.7, 50293439, "South Korea", 2015],
                [34186, 80.6, 4528526, "New Zealand", 2015],
                [64304, 81.6, 5210967, "Norway", 2015],
                [24787, 77.3, 38611794, "Poland", 2015],
                [23038, 73.13, 143456918, "Russia", 2015],
                [19360, 76.5, 78665830, "Turkey", 2015],
                [38225, 81.4, 64715810, "United Kingdom", 2015],
                [53354, 79.1, 321773631, "United States", 2015],
            ],
        ];
export default {
    name: 'Home',
    data() {
        return {
            msg: 'Welcome to Your Vue.js App',
            tableData: [
                {
                    date: "2016-05-02",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-04",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1517 弄",
                },
                {
                    date: "2016-05-01",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1519 弄",
                },
                {
                    date: "2016-05-03",
                    name: "王小虎",
                    address: "上海市普陀区金沙江路 1516 弄",
                },
            ],
            systemData: [
                {
                    id: 1,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
                {
                    id: 2,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
                {
                    id: 3,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
                {
                    id: 4,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
                {
                    id: 5,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
                {
                    id: 6,
                    date: "2022-10-21 09:00",
                    title: "【内部分享】如何建立良好的客户关系",
                    icon: 'timer'
                },
            ],

        }

    },
    mounted(){
        // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(this.$refs.echarts1);

        // 指定图表的配置项和数据
        var option1 = {
            legend: {
                // Try 'horizontal'
                orient: "vertical",
                right: 10,
                top: "center",
            },
            dataset: {
                source: [
                    ["product", "2015", "2016", "2017"],
                    ["Matcha Latte", 43.3, 85.8, 93.7],
                    ["Milk Tea", 83.1, 73.4, 55.1],
                    ["Cheese Cocoa", 86.4, 65.2, 82.5],
                    ["Walnut Brownie", 72.4, 53.9, 39.1],
                ],
            },
            xAxis: { type: "category" },
            yAxis: {},
            series: [{ type: "bar" }, { type: "bar" }, { type: "bar" }],
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart1.setOption(option1);
        
        var myChart2 = echarts.init(this.$refs.echarts2);
        
        const option2 = {
            backgroundColor: {
                type: "radial",
                x: 0.3,
                y: 0.3,
                r: 0.8,
                colorStops: [
                    {
                        offset: 0,
                        color: "#f7f8fa",
                    },
                    {
                        offset: 1,
                        color: "#cdd0d5",
                    },
                ],
            },
            grid: {
                left: 10,
                containLabel: true,
                bottom: 10,
                top: 10,
                right: 30,
            },
            xAxis: {
                splitLine: {
                    show: false,
                },
            },
            yAxis: {
                splitLine: {
                    show: false,
                },
                scale: true,
            },
            series: [
                {
                    name: "1990",
                    data: data[0],
                    type: "scatter",
                    symbolSize: function (data) {
                        return Math.sqrt(data[2]) / 5e2;
                    },
                    emphasis: {
                        focus: "series",
                        label: {
                            show: true,
                            formatter: function (param) {
                                return param.data[3];
                            },
                            position: "top",
                        },
                    },
                    itemStyle: {
                        shadowBlur: 10,
                        shadowColor: "rgba(120, 36, 50, 0.5)",
                        shadowOffsetY: 5,
                        color: {
                            type: "radial",
                            x: 0.4,
                            y: 0.3,
                            r: 1,
                            colorStops: [
                                {
                                    offset: 0,
                                    color: "rgb(251, 118, 123)",
                                },
                                {
                                    offset: 1,
                                    color: "rgb(204, 46, 72)",
                                },
                            ],
                        },
                    },
                },
                {
                    name: "2015",
                    data: data[1],
                    type: "scatter",
                    symbolSize: function (data) {
                        return Math.sqrt(data[2]) / 5e2;
                    },
                    emphasis: {
                        focus: "series",
                        label: {
                            show: true,
                            formatter: function (param) {
                                return param.data[3];
                            },
                            position: "top",
                        },
                    },
                    itemStyle: {
                        shadowBlur: 10,
                        shadowColor: "rgba(25, 100, 150, 0.5)",
                        shadowOffsetY: 5,
                        color: {
                            type: "radial",
                            x: 0.4,
                            y: 0.3,
                            r: 1,
                            colorStops: [
                                {
                                    offset: 0,
                                    color: "rgb(129, 227, 238)",
                                },
                                {
                                    offset: 1,
                                    color: "rgb(25, 183, 207)",
                                },
                            ],

                        },
                    },
                },
            ],
        };
        

        myChart2.setOption(option2);

        var myChart3 = echarts.init(this.$refs.echarts3);
        
        var option3 = {
            title: {
                text: "销售数据",
            },
            tooltip: {},
            legend: {
                data: ["销量"],
            },
            xAxis: {
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
            },
            yAxis: {},
            series: [
                {
                    name: "销量",
                    type: "bar",
                    data: [5, 20, 36, 10, 10, 20],
                },
            ],
        };
        

        myChart3.setOption(option3);
    }
}
</script>
<!-- <style lang="less" scoped>
.el-row {
    margin-bottom: 20px;

    &:last-child {
        margin-bottom: 0;
    }
}

.el-col {
    border-radius: 4px;
}

.bg-purple-dark {
    background: #99a9bf;
}

.bg-purple {
    background: #d3dce6;
}

.bg-purple-light {
    background: #e5e9f2;
}

.grid-content {
    border-radius: 4px;
    min-height: 36px;
}

.row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
}
</style> -->

<style lang="less" scoped>
.user {
    padding-bottom: 20px;
    margin-bottom: 20px;
    border-bottom: 1px solid #ccc;
    display: flex;
    align-items: center;

    img {
        margin-left: 40px;
        width: 150px;
        height: 150px;
        border-radius: 40%;
    }

    .userinfo {
        margin-left: 40px;

        .name {
            font-size: 32px;
            margin-bottom: 10px;
        }

        .access {
            color: #999;
        }
    }
}

.login-info {
    p {
        line-height: 28px;
        font-size: 14px;
        color: #999999;

        span {
            color: #666666;
            margin-left: 20px;
        }
    }
}

.system_bulletin {
    .system_title {
        font-size: 22px;
        color: #000000;
    }

    .system_context {
        padding-bottom: 10px;
        margin-bottom: 10px;
        border-bottom: 1px solid rgb(242, 242, 242);
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
}
</style>