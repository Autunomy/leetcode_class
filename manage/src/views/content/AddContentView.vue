<template>
<div>
    <form class="row g-3">
        <div class="col-auto" style="width: 1000px;">
            <input v-model="content.title" type="text" class="form-control" placeholder="请输入标题">
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" style="margin-bottom: 10px;width: 100px;" @click.prevent="addContent">提交</button>
            &nbsp;
            <span style="color: red">{{message}}</span>
        </div>
    </form>

    <v-md-editor
        v-model="content.content"
        height="740px"></v-md-editor>
</div>
</template>

<script>
import $ from 'jquery';
import {useRoute,useRouter} from "vue-router";
import {reactive, ref} from "vue";

export default {
    name: "AddContentView",
    setup(){
        const route = useRoute();
        const router = useRouter();
        let problemId = route.params.problemId;
        let message = ref("");
        const content = reactive({
            title:"",
            content:"",
            problemId:problemId,
        })

        const addContent = () => {
            message.value = "";
            $.ajax({
                url:"http://localhost:8001/manage/content/add",
                type:"post",
                data:{
                    title:content.title,
                    content:content.content,
                    problemId:content.problemId,
                },
                success(resp){
                    if(resp.message === "success"){
                        router.push('/')
                    }else{
                        message.value = resp.message;
                    }
                }
            })
        }

        return{
            content,
            addContent,
            message,
        }
    },
}
</script>

<style scoped>

</style>