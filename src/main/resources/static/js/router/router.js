import Vue from 'vue'
import VueRouter from 'vue-router'
import ProducersList from 'pages/ProducerList.vue'
import Auth from 'pages/Auth.vue'
import Profile from 'pages/Profile.vue'

Vue.use(VueRouter);

const routes = [
  {path: '/', component: ProducersList},
  {path: '/auth', component: Auth},
  {path: '/profile', component: Profile},
  {path: '*', component: ProducersList}
];

export default new VueRouter({
  mode: 'history',
  routes
});
