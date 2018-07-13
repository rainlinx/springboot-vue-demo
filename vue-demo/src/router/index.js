import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/pages/HomePage'
import MainPage from '@/pages/MainPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/MainPage',
      name: 'MainPage',
      component: MainPage
    }
  ]
})
