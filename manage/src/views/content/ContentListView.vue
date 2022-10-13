<template>
    <div>
        <router-link :to="{name:'home'}">&lt;-返回</router-link>
        <div style="text-align: center">
            <h2 style="display: inline-block;">{{ problem.title }}</h2>
        </div>
        <hr>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>标题</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="content in contents" :key="content.id">
                <td>
                    <router-link :to="{name:'showContent',params:{contentId:content.id}}">{{content.title}}</router-link>
                </td>
                <td>
                    {{content.createTime}}
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {ref} from "vue";
import $ from "jquery";
import {useRoute} from "vue-router";

export default {
    name: "ContentListView",
    setup(){
        let contents = ref([]);
        const route = useRoute();
        let problemId = route.params.problemId;
        let problem = ref({});
        const getContentList = () => {
            $.ajax({
                url:"http://127.0.0.1:8001/content/list",
                type:"get",
                data:{
                    problemId,
                },
                success(resp){
                    contents.value = resp.contents
                }
            })
        }
        getContentList();
        const getProblemById = () => {
            $.ajax({
                url:"http://127.0.0.1:8001/problem/getbyid",
                type:"get",
                data:{
                    problemId,
                },
                success(resp){
                    problem.value = resp.problem;
                }
            })
        }
        getProblemById();

        return{
            contents,
            problem,
        }
    }
}
</script>

<style scoped>

</style>