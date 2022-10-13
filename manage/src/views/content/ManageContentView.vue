<template>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>题目</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="content in contentList" :key="content.id">
                <td>{{ content.title }}</td>
                <td>{{ content.createTime }}</td>
                <td>{{ content.problemName }}</td>
                <td>
                    <button class="btn btn-primary btn-sm" style="margin-right: 10px">修改</button>
                    <button class="btn btn-danger btn-sm">删除</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {ref} from "vue";
import $ from 'jquery';

export default {
    name: "ManageContentView",
    setup(){
        let contentList = ref([]);

        const getContentList = () => {
            $.ajax({
                url:"http://localhost:8001/manage/content/list",
                type:"get",
                success(resp){
                    contentList.value = resp;
                }
            })
        }
        getContentList()


        return{
            contentList,
        }
    }
}
</script>

<style scoped>

</style>