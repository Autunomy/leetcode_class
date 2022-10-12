<template>
    <ContentComponent>
        <div>
            <div style="text-align: center">
                <h2>标签</h2>
            </div>
            <div style="text-align: center">
                <button v-for="tag in tagList" :key="tag.id" type="button" class="btn btn-light">
                    {{tag.name}}
                </button>
            </div>
            <hr>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>标题</th>
                        <th>题解地址</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="problem in problemList" :key="problem.id">
                        <td>{{problem.title}}</td>
                        <td>
                            <router-link :to="{name:'contentList',params:{problemId:problem.id}}">点击跳转</router-link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </ContentComponent>
</template>

<script>
import ContentComponent from "@/components/ContentComponent";
import {ref} from "vue";
import $ from "jquery";

export default {
    name: "ProblemContentView",
    components:{
        ContentComponent,
    },
    setup(){
        let tagList = ref([]);
        let problemList =ref([]);
        const getTagList = () => {
            $.ajax({
                url:"http://127.0.0.1:8001/tag/list",
                type:"get",
                success(resp){
                    tagList.value = resp.tags;
                },
                error(resp){
                    console.log(resp);
                }
            })
        }
        getTagList();

        const getProblemList = () => {
            $.ajax({
                url:"http://127.0.0.1:8001/problem/getlist",
                type:"get",
                success(resp){
                    problemList.value = resp.problems;
                },
                error(resp){
                    console.log(resp);
                }
            })
        }
        getProblemList();

        return{
            tagList,
            problemList,
        }
    }
}
</script>

<style scoped>
button{
    border: 1px black solid;
    margin-left: 10px;
    margin-top: 10px;
}
</style>