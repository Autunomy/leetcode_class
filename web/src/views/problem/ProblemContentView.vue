<template>
    <div>
        <div style="text-align: center">
            <h3>点击标签显示对应标签的题目</h3>
        </div>
        <div style="text-align: center">
            <button @click="problemWithTag(tag.id,tag.name)" v-for="tag in tagList" :key="tag.id" type="button" class="btn btn-light">
                {{tag.name}}
            </button>
        </div>
        <hr>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>标题</th>
                <th>题解地址</th>
                <th>标签</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="problem in problemList" :key="problem.id">
                <td>{{problem.title}}</td>
                <td>
                    <router-link :to="{name:'contentList',params:{problemId:problem.id}}">点击跳转</router-link>
                </td>
                <td>{{nowTag}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {ref} from "vue";
import $ from "jquery";

export default {
    name: "ProblemContentView",
    setup(){
        let tagList = ref([]);
        let problemList =ref([]);
        let nowTag = ref("");
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

        // const getProblemList = () => {
        //     $.ajax({
        //         url:"http://127.0.0.1:8001/problem/getlist",
        //         type:"get",
        //         success(resp){
        //             problemList.value = resp.problems;
        //         },
        //         error(resp){
        //             console.log(resp);
        //         }
        //     })
        // }
        // getProblemList();

        const problemWithTag = (tagId,tagName) => {
            $.ajax({
                url:"http://127.0.0.1:8001/problem/getbytag",
                type:"get",
                data:{
                    tagId,
                },
                success(resp){
                    problemList.value = resp;
                    nowTag.value = tagName;
                },
                error(resp){
                    console.log(resp);
                }
            })
        }

        return{
            tagList,
            problemList,
            problemWithTag,
            nowTag,
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