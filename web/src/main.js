import { createApp } from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import VMdPreviewHtml from '@kangc/v-md-editor/lib/preview-html';
import '@kangc/v-md-editor/lib/style/preview-html.css';
// 引入使用主题的样式
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';

createApp(App).use(VMdPreviewHtml).use(store).use(router).mount('#app');




