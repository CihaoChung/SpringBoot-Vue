<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="图书作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>
        <el-form-item label="图书出版社" prop="publish">
            <el-input v-model="ruleForm.publish"></el-input>
        </el-form-item>
        <el-form-item label="图书总页数" prop="pages">
            <el-input v-model="ruleForm.pages"></el-input>
        </el-form-item>
        <el-form-item label="图书价格" prop="price">
            <el-input v-model="ruleForm.price"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>

</template>

<script>
    export default {

        data() {
            function validateAcquaintance (rule, value, callback) {
                if (!value) {
                    callback(new Error('必须为数字'))
                }
                value = Number(value);
                if (typeof value === 'number' && !isNaN(value)) {
                   /* if (value < 0 || value > 100) {
                        callback(new Error('熟悉程度在 0 至 100 %之间'))
                    } else {
                        callback()
                    }*/
                } else {
                    callback(new Error('必须为数字'))
                }
            }
            return {
                ruleForm: {
                    name: '',
                    author: '',
                    publish: '',
                    pages: '',
                    price: ''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入图书名称', trigger: 'blur'},
                        // {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    author: [
                        {required: true, message: '请选择图书作者', trigger: 'change'}
                    ],
                    publish: [
                        {required: true, message: '请输入图书出版社', trigger: 'blur'},
                    ],
                    pages: [
                        { required: true, message: '请输入图书总页数'},
                        // { type: 'number', message: '必须为数字值',trigger: 'change'},
                        // {validator: validateAcquaintance}
                    ],
                    price: [
                        {required: true, message: '请输入图书价格'},
                        // {type: 'number', message: '必须为数字值',trigger: 'change'},
                        // {validator: validateAcquaintance}
                    ],
                }
            };
        },

        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                          axios.post('http://localhost:8181/book/save',this.ruleForm).then(function (resp) {
                              console.log(resp);
                            if (resp.data.code=='success') {
                                _this.$alert('《'+_this.ruleForm.name+'》'+resp.data.msg,'消息',{
                                    confirmButtonText: '确定',
                                    callback:action => {
                                        //跳转
                                        _this.$router.push('/BookManage')
                                    }
                                })
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

