<template>
  <el-container>
    <el-header>
      <Header :headerMsg="headerMsg"></Header>
    </el-header>
    <el-main style="text-align: center;">
      <el-row type="flex" justify="center">
        <el-col :span="6">
          <el-tabs v-model="activeName">
            <el-tab-pane label="登录" name="loginTab">
              <Login></Login>
            </el-tab-pane>
            <el-tab-pane label="注册" name="registerTab">
              <Register></Register>
            </el-tab-pane>
          </el-tabs>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import Header from '@/components/Header'
  import Login from '@/components/Login'
  import Register from '@/components/Register'

  export default {
    name: "HomePage",
    components: {Header, Login, Register},
    data() {
      return {
        headerMsg: 'Xmos',
        activeName: 'loginTab'
      }
    }
  }
</script>

<style scoped>
  .el-header {
    background-color: #409EFF;
    color: white;
  }
</style>
