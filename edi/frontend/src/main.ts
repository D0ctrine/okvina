import { createApp } from 'vue'
import router from './router'
import store from './store'
import './style.css'
import App from './App.vue'
import VueSplide from '@splidejs/vue-splide';

createApp(App)
.use(router)
.use(store)
.use(VueSplide)
.mount('#app')
