<template>
  <div id="AlterUser">
    <el-form :model="alterUserForm" ref="alterUserForm" :rules="rules">
      <el-form-item prop="name">
        <el-input v-model="alterUserForm.name" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="alterUserForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item prop="age">
        <el-input v-model="alterUserForm.age" placeholder="年龄"></el-input>
      </el-form-item>
      <el-form-item prop="dept">
        <el-input v-model="alterUserForm.dept" placeholder="部门"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="AlterUser('alterUserForm')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "AlterUser",
    data() {
      return {
        rules: {
          name: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
          age: [{required: true, message: '请输入年龄', trigger: 'blur'}],
          dept: [{required: true, message: '请输入部门', trigger: 'blur'}],
        }
      }
    },
    props: ['alterUserForm'],
    methods: {
      AlterUser(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post(
              '/user/alterUser',
              {
                user: this.alterUserForm,
                operations: 'update'
              }
            )
              .then(res => {
                alert(res.data)
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
