<template>
  <div id="Register">
    <el-form :model="registerForm" ref="registerForm" :rules="rules">
      <el-form-item prop="name">
        <el-input v-model="registerForm.name" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="registerForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item prop="age">
        <el-input v-model="registerForm.age" placeholder="年龄"></el-input>
      </el-form-item>
      <el-form-item prop="dept">
        <el-input v-model="registerForm.dept" placeholder="部门"></el-input>
      </el-form-item>
      <el-form-item prop="level">
        <el-input v-model="registerForm.level" placeholder="等级"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="register('registerForm')">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data() {
      return {
        rules: {
          name: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
          age: [{required: true, message: '请输入年龄', trigger: 'blur'}],
          dept: [{required: true, message: '请输入部门', trigger: 'blur'}],
          level: [{required: true, message: '请输入等级', trigger: 'blur'}],
        },
        registerForm: {
          name: '',
          password: '',
          age: '',
          dept: '',
          level: ''
        }
      }
    },
    methods: {
      register(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post(
              '/user/register',
              this.registerForm
            )
              .then(res => {
                if (res.data === 's0000') {
                  this.$message({message: '注册成功', type: 'success'});
                } else if (res.data === 'e1002') {
                  this.$message({message: '该用户已被注册', type: 'warn'});
                }
                this.$refs['registerForm'].resetFields();
              })
              .catch(error => {

              })
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
