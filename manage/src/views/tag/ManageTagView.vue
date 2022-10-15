<template>
    <div>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTag">添加标签</button>
        <!-- Modal -->
        <div class="modal fade" id="addTag" style="margin-top: 10vh">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加题目</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="name" class="form-label">标签名</label>
                            <input v-model="tagName" type="text" class="form-control" id="name" placeholder="请输入标签名称">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <span style="color: red">{{ message }}</span>
                        <button type="button" class="btn btn-primary" @click="addTag">提交</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="tag in tagList" :key="tag.id">
                <td>{{ tag.name }}</td>
                <td>
                    <button class="btn btn-danger btn-sm"
                            data-bs-toggle="modal"
                            :data-bs-target="'#deleteTag' + tag.id">删除</button>
                    <!-- Modal -->
                    <div class="modal fade" :id="'deleteTag' + tag.id" style="margin-top: 10vh">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">删除标签</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    是否删除 {{tag.name}} 标签？
                                </div>
                                <div class="modal-footer">
                                    <span style="color: red">{{ message }}</span>
                                    <button type="button" class="btn btn-danger" @click="deleteTag(tag.id)">删除</button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {ref} from "vue";
import $ from 'jquery';
import {Modal} from "bootstrap/dist/js/bootstrap";


export default {
    name: "ManageTagView",
    setup(){
        let tagList = ref([]);
        let tagName = ref("");
        let message = ref("");


        const getTagList = () => {
            $.ajax({
                url:"http://localhost:8001/manage/tag/list",
                type:"get",
                success(resp){
                    console.log(resp)
                    tagList.value = resp;
                },
                error(resp){
                    message.value = resp.message;
                }
            })
        }
        getTagList();

        const addTag = () => {
            message.value = "";
            $.ajax({
                url: "http://127.0.0.1:8001/manage/tag/add",
                type: "post",
                data: {
                    name: tagName.value,
                },
                success(resp) {
                    if (resp.message !== "success") {
                        message.value = resp.message;
                    } else {
                        tagName.value = ""
                        getTagList();
                        Modal.getInstance("#addTag").hide();//关闭模态框
                    }
                }
            })
        }

        const deleteTag = tagId => {
            $.ajax({
                url:"http://localhost:8001/manage/tag/delete",
                type:"post",
                data:{
                    tagId,
                },
                success(resp){
                    if(resp.message === "success"){
                        Modal.getInstance("#deleteTag" + tagId).hide();//关闭模态框
                        getTagList();
                    }else{
                        message.value = resp.message;
                    }

                },
                error(resp){
                    console.log(resp);
                }
            })
        }
        return{
            tagList,
            tagName,
            message,
            addTag,
            deleteTag,
        }
    }
}
</script>

<style scoped>

</style>