<template>
    <ContentComponent>
        <router-link :to="{name:'home'}">&lt;-回到首页</router-link>
        <div style="text-align: center">
            <h2 style="display: inline-block;">两数之和</h2>
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
                    <router-link :to="{name:''}">{{content.title}}</router-link>
                </td>
                <td>
                    {{content.createTime}}
                </td>
            </tr>
            </tbody>
        </table>
    </ContentComponent>
</template>

<script>
import ContentComponent from "@/components/ContentComponent";
import {ref} from "vue";
import $ from "jquery";
import {useRoute} from "vue-router";

export default {
    name: "ContentListView",
    components:{
        ContentComponent,
    },
    setup(){
        let contents = ref([]);
        const route = useRoute();
        let problemId = route.params.problemId;
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

        return{
            contents,
        }
    }
}
</script>

<style scoped>

</style>