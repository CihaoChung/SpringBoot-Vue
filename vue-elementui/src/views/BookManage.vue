<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    >
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名"
                  >
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    >
            </el-table-column>
            <el-table-column
                    prop="publish"
                    label="出版社"
            >
            </el-table-column>
            <el-table-column
                    prop="pages"
                    label="书本页数"
            >
            </el-table-column>
            <el-table-column
                    prop="price"
                    label="价格(本/元)"
            >
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                   >
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                    <!--<el-button type="text" size="small">编辑</el-button>-->
                </template>
            </el-table-column>
        </el-table>
        <!-- @current-change="page"绑定点击事件-->
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page"
        >
        </el-pagination>
    </div>

</template>

<script>
    export default {
        methods: {
            handleClick(row) {
                console.log(row);
            },
            deleteBook(row){
                const  _this = this;
          /*      axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function(resp){
                        _this.$message({
                            type: 'success',
                            message: '《'+row.name+'》删除成功！'
                        });*/
                this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(async  () =>{
                        axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function(resp) {
                            _this.$message({
                                type: 'success',
                                message: '《' + row.name + '》删除成功！'
                            })
                        });
                    window.location.reload();
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },


            edit(row){
                this.$router.push({
                    path:'/update',
                    query:{
                        id:row.id
                    }
                })
            },
            page(currentPage){
                const _this=this;
                axios.get('http://localhost:8181/book/findAll/'+(currentPage-1)+'/4').then(function (resp) {
                    _this.tableData =  resp.data.content;
                    _this.pageSize =resp.data.size;
                    _this.total =resp.data.totalElements;
                })
            }
        },

        data() {
            return {
                pageSize:0,
                total:4,
                tableData: []
            }
        },
        created() {
            const _this=this;
            axios.get('http://localhost:8181/book/findAll/0/4').then(function (resp) {
                _this.tableData =  resp.data.content;
                _this.pageSize =resp.data.size;
                _this.total =resp.data.totalElements;
            })
        }
    }
</script>