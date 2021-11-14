import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: () => import('../views/Login.vue'),
      isPublic: true
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../views/Login.vue'),
      isPublic: true
    },
    {
      path: '/sign-up',
      name: 'SignUp',
      component: () => import('../views/SignUp.vue'),
      isPublic: true
    },
    {
      path: '/book',
      name: 'Book',
      component: () => import('../views/Book.vue'),
      isPublic: true
    },
  ]
})
