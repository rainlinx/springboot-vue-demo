<template>
  <el-container>
    <el-main>
      <el-form :model="loginForm" ref="loginForm" :rules="rules">
        <el-form-item prop="name">
          <el-input v-model="loginForm.name">
            <template slot="prepend">账号</template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password">
            <template slot="prepend">密码</template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login('loginForm')">登陆</el-button>
          <el-button @click="reset('loginForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>

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
                if (res.data === '0000') {
                  this.$message({message: '登陆成功', type: 'success'});
                } else if (res.data === '1001') {
                  this.$alert('密码错误');
                } else if (res.data === '1002') {
                  this.$alert('账号不存在');
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
