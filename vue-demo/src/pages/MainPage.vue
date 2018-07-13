<template>
  <el-container>
    <el-header>
      <Header :userName="userName" :dept="dept"></Header>
    </el-header>
    <el-container style="justify-content: center;">
      <el-form :inline="true" :model="searchForm" ref="searchForm">
        <el-form-item>
          <el-select v-model="searchForm.dept" clearable placeholder="请选择部门">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="searchForm.name" clearable placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="subForm">确定</el-button>
          <el-button @click="addUser">新增</el-button>
        </el-form-item>
      </el-form>
    </el-container>
    <el-container style="justify-content: center;">
      <div style="width: 600px;">
        <el-table :data="userList" border>
          <el-table-column prop="name" label="姓名">
          </el-table-column>
          <el-table-column prop="age" label="年龄">
          </el-table-column>
          <el-table-column prop="dept" label="部门">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text">查看</el-button>
              <el-button type="text">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-container>
    <el-dialog title="用户信息" :visible.sync="isShowDialog">
      <!--<el-form>-->
      <!--<el-form-item label="姓名">-->
      <!--<el-input></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="密码">-->
      <!--<el-input></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="年龄">-->
      <!--<el-input></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="部门">-->
      <!--<el-input></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="等级">-->
      <!--<el-input></el-input>-->
      <!--</el-form-item>-->
      <!--</el-form>-->
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </el-container>
</template>

<script>
  import Header from '@/components/Header'
  import UserDialog from '@/components/UserDialog'

  export default {
    name: "MainPage",
    data() {
      return {
        userName: '',
        dept: '',
        searchForm: {
          dept: '',
          userName: ''
        },
        userList: [],
        options: [{
          label: '技管部',
          value: 'it'
        }, {
          label: '公司部',
          value: 'company'
        }],
        isShowDialog: false
      }
    },
    created() {
      let user = JSON.parse(sessionStorage.getItem('user'))
      this.name = user.name

    },
    methods: {
      subForm() {
        let user = this.searchForm
        this.$axios.post(
          '/user/findUser',
          user
        )
          .then(res => {
            this.userList = res.data
          })
          .catch(error => {

          })
      },
      addUser() {
        this.isShowDialog = true
      }
    },
    components: {Header, UserDialog}
  }
</script>

<style scoped>

</style>
