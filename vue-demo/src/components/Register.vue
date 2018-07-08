<template>
  <el-container>
    <el-main>
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
        <el-form-item>
          <el-button type="primary" @click="register('registerForm')">注册</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
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
        },
        registerForm: {
          name: '',
          password: '',
          age: '',
          dept: '',
          level: '1'
        }
      }
    },
    methods: {
      register(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post(
              '/xmos/register',
              this.registerForm
            )
              .then(res => {
                if (res.data == '0000') {
                  this.$alert('注册成功');
                } else if (res.data == '1002') {
                  this.$alert('该用户已被注册');
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
