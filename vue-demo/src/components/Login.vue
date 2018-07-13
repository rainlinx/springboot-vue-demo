<template>
  <div id="Login">
    <el-form :model="loginForm" ref="loginForm" :rules="rules">
      <el-form-item prop="name">
        <el-input v-model="loginForm.name" placeholder="用户名">
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" type="password" placeholder="密码">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click="login('loginForm')">登陆</el-button>
        <el-button round @click="reset('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        loginForm: {
          name: '',
          password: ''
        },
        rules: {
          name: [{required: true, message: '请输入账号', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
    props: ['jump']
      }
    },
    methods: {
      login(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post(
              '/login',
              this.loginForm
            )
              .then(res => {
                if (res.data === 's0000') {
                  this.$message({message: '登陆成功', type: 'success'})
                  sessionStorage.setItem('user', JSON.stringify(this.loginForm))
                  this.$router.push({name: 'MainPage'})
                } else if (res.data === 'e1001') {
                  this.$alert('密码错误')
                } else if (res.data === 'e1002') {
                  this.$alert('账号不存在')
                }
              })
              .catch(error => {

              })
          } else {
            return false;
          }
        });
      },
      reset(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
