<template>
  <el-container id="HomePage">
    <div class="change">
      <div>
        <el-button type="text" @click="changeView('登录')">登录</el-button>
        <el-button type="text" @click="changeView('注册')">注册</el-button>
      </div>
      <Login v-if="showLogin"></Login>
      <Register v-if="showRegister"></Register>
    </div>
  </el-container>
</template>

<script>
  import Login from '@/components/Login'
  import Register from '@/components/Register'

  export default {
    name: "HomePage",
    components: {Login, Register},
    data() {
      return {
        showLogin: true,
        showRegister: false
      }
    },
    methods: {
      changeView(btnName) {
        if (btnName === '登录') {
          this.showLogin = true
          this.showRegister = false
        } else {
          this.showLogin = false
          this.showRegister = true
        }
      }
    }
  }
</script>

<style scoped>
  #HomePage {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: #f1f1f1;
  }

  .change {
    background-color: white;
    -webkit-border-radius: 24px;
    -moz-border-radius: 24px;
    border-radius: 24px;
    margin: auto;
    text-align: center;
    width: 300px;
    height: 350px;
  }

  #Login {
    margin: 60px 30px 30px 30px;
  }

  #Register {
    margin: 0px 30px 30px 30px;
  }
</style>
