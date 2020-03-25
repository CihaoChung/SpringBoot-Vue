<template>
  <div id="app">
      <!--el-container表示构建整个页面-->
      <el-container style="height: 500px; border: 1px solid #eee">
          <!--el-aside左侧菜单-->
          <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
              <!--el-menu左侧菜单里的内容-->
              <!--:default-openeds选中默认展开那些菜单--index-->
              <!--:default-active:表示默认选中的菜单，也是通过index选取-->
              <!--<el-menu :default-openeds="[ '1','3']" :default-active="'1-1'">
              &lt;!&ndash;
              el-submenu:可展开的菜单，常用属性
              index:菜单的下标，文本类型，不能是数值类型
              &ndash;&gt;
                <el-submenu index="1">
                    &lt;!&ndash;
                    template：对应el-submenu的菜单名
                    i标签设置菜单图标，通过class属性实例
                    &ndash;&gt;
                  <template slot="title"><i class="el-icon-message"></i>导航一</template>
                  <el-menu-item-group>
                    <template slot="title">分组一</template>
                      &lt;!&ndash;el-menu-item：不可再展开的子节点，index&ndash;&gt;
                    <el-menu-item index="1-1">选项1</el-menu-item>
                    <el-menu-item index="1-2">选项2</el-menu-item>
                  </el-menu-item-group>

                </el-submenu>
              </el-menu>-->
              <el-menu router :default-openeds="['0','1']">
                  <!--$router.options相当于读取router里的配置文件index.js-->
                  <!--:index="index+''"区分单击事件，是否展开是按index来判断是不是一起-->
                  <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
                      <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
                      <!--$route.path表示locathost:8080/PageOne中的PageOne，$route表示整体-->
                      <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                                    :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
                  </el-submenu>
              </el-menu>
          </el-aside>
              <el-main>
                  <!-- <el-table :data="tableData">
                     <el-table-column prop="date" label="日期" width="140">
                     </el-table-column>
                     <el-table-column prop="name" label="姓名" width="120">
                     </el-table-column>
                     <el-table-column prop="address" label="地址">
                     </el-table-column>
                   </el-table>-->
                  <!-- 路由匹配到的组件将显示在这里主要是显示pageOne这类界面 -->
                  <router-view></router-view>
              </el-main>
      </el-container>
  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>
