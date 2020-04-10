import Vue from 'vue'
import VueRouter from 'vue-router'
import ProducersList from 'components/producer/ProducerList.vue'
import Paint from 'pages/Paint.vue'
import Hello from 'pages/Hello.vue'
import Auth from 'pages/Auth.vue'
import Profile from 'pages/Profile.vue'

Vue.use(VueRouter);

const routes = [
  {path: '/', component: Hello},
  {path: '/producers', component: ProducersList},
  {path: '/paints', component: Paint},
  {path: '/auth', component: Auth},
  {path: '/profile', component: Profile},
  {path: '*', component: ProducersList}
];

export default new VueRouter({
  mode: 'history',
  routes
});
