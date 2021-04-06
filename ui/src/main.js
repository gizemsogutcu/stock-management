// import Vue from 'vue'
// import App from './App.vue'
//
// Vue.config.productionTip = false
//
// new Vue({
//   render: h => h(App),
// }).$mount('#app')

import VueConfirmDialog from 'vue-confirm-dialog'
import Vue from 'vue'
import App from './App.vue'
import router from './routes';

Vue.use(VueConfirmDialog)
Vue.component('vue-confirm-dialog', VueConfirmDialog.default)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

