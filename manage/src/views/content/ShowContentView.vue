<template>
    <div>
        <router-link :to="{name:'contentList',params:{problemId}}">&lt;-返回</router-link>
        <div style="text-align: center">
            <h2 style="display: inline-block;">{{content.title}}</h2>
        </div>
        <div>
            <span style="float: right">{{content.create_time}}</span>
        </div>
        <br>
        <hr>
        <v-md-preview-html :html="content.content" preview-class="vuepress-markdown-body"></v-md-preview-html>
    </div>
</template>

<script>
import {useRoute} from "vue-router";
import {ref,reactive} from "vue";
import $ from "jquery";
import {onMounted} from "vue";
import {marked} from "marked";

export default {
    name: "ShowContentView",
    setup(){
        const route = useRoute();
        let problemId = ref(0);
        let contentId = route.params.contentId;
        let content = reactive({
            id:"",
            title:"",
            content:"",
            problemId:"",
            create_time:""
        });

        onMounted(() => {
            showContent();
        })

        const showContent = () => {
            $.ajax({
                url:"http://127.0.0.1:8001/content/show",
                type:"get",
                data:{
                    contentId,
                },
                success(resp){
                    problemId.value = resp.content.problemId;
                    content.id = resp.content.id;
                    content.title = resp.content.title;
                    content.content = marked(resp.content.content);
                    content.problemId = resp.content.problemId;
                    content.create_time = resp.content.createTime;
                }
            })
        }

        return{
            problemId,
            content,
        }
    }
}
</script>

<style scoped>
</style>