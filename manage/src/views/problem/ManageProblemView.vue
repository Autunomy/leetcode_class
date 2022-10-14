<template>
    <div>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addProblem">添加题目</button>
        <!-- Modal -->
        <div class="modal fade" id="addProblem" style="margin-top: 10vh">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">添加题目</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="title" class="form-label">标题</label>
                            <input v-model="title" type="text" class="form-control" id="title" placeholder="请输入题目标题">
                        </div>
                        <div class="mb-3">
                            <label for="link" class="form-label">链接地址</label>
                            <input v-model="link" type="text" class="form-control" id="link" placeholder="请输入链接地址">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">标签</label>
                            <select v-model="tagId" class="form-select">
                                <option value="-1">请选择标签</option>
                                <option v-for="tag in tagList" :value="tag.id" :key="tag.id">{{ tag.name }}</option>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <span style="color: red">{{ message }}</span>
                        <button type="button" class="btn btn-primary" @click="addProblem">提交</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>标题</th>
                <th>标签</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="problem in problemList" :key="problem.id">
                <td>{{ problem.title }}</td>
                <td>{{ problem.tagName }}</td>
                <td>
                    <button class="btn btn-primary btn-sm"
                            style="margin-right: 10px"
                            data-bs-toggle="modal"
                            data-bs-target="#updateProblem"
                            @click="getProblemById(problem.id)">修改</button>

                    <!-- Modal -->
                    <div class="modal fade" id="updateProblem" style="margin-top: 10vh">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">修改题目</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="title" class="form-label">标题</label>
                                        <input v-model="title" type="text" class="form-control" id="title" placeholder="请输入题目标题">
                                    </div>
                                    <div class="mb-3">
                                        <label for="link" class="form-label">链接地址</label>
                                        <input v-model="link" type="text" class="form-control" id="link" placeholder="请输入链接地址">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">标签</label>
                                        <select v-model="tagId" class="form-select">
                                            <option value="-1">请选择标签</option>
                                            <option v-for="tag in tagList" :value="tag.id" :key="tag.id">{{ tag.name }}</option>
                                        </select>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <span style="color: red">{{ message }}</span>
                                    <button type="button" class="btn btn-primary" @click="updateProblem(problem.id)">修改</button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <button class="btn btn-danger btn-sm"
                            style="margin-right: 10px"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteProblem">删除</button>
                    <!-- Modal -->
                    <div class="modal fade" id="deleteProblem" style="margin-top: 10vh">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">删除题目</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    是否删除当前题目？
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" @click="deleteProblem(problem.id)">删除</button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <button class="btn btn-warning btn-sm" @click="toAdd(problem.id)">编写题解</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import {ref} from "vue";
import $ from "jquery";
import {Modal} from "bootstrap/dist/js/bootstrap";
import {useRouter} from "vue-router";


export default {
    name: "ManageProblemView",
    setup() {
        let tagList = ref([]);
        let problemList = ref([]);
        let nowTag = ref("");
        let title = ref("");
        let link = ref("");
        let tagId = ref(-1);
        const router = useRouter();

        let message = ref("");

        const getTagList = () => {
            $.ajax({
                url: "http://127.0.0.1:8001/tag/list",
                type: "get",
                success(resp) {
                    tagList.value = resp.tags;
                },
                error(resp) {
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
                    problemList.value = resp;
                },
                error(resp){
                    console.log(resp)
                }
            })
        }
        getProblemList();

        const addProblem = () => {
            message.value = "";
            $.ajax({
                url: "http://127.0.0.1:8001/manage/problem/add",
                type: "post",
                data: {
                    title: title.value,
                    link: link.value,
                    tagId: tagId.value,
                },
                success(resp) {
                    if (resp.message !== "success") {
                        message.value = resp.message;
                    } else {
                        title.value = "";
                        link.value = "";
                        tagId.value = -1;
                        getProblemList();
                        Modal.getInstance("#addProblem").hide();//关闭模态框
                    }
                }
            })
        }

        const toAdd = problemId => {
            router.push({
                name:"addContent",
                params:{
                    problemId,
                }
            })
        }

        const getProblemById = problemId => {
            $.ajax({
                url:"http://127.0.0.1:8001/problem/getbyid",
                type:"get",
                data:{
                    problemId,
                },
                success(resp){
                    title.value = resp.problem.title;
                    link.value = resp.problem.link;
                    tagId.value = resp.problem.tagId;
                },
                error(resp){
                    console.log(resp);
                }
            })
        }

        const updateProblem = problemId => {
            message.value = "";
            $.ajax({
                url:"http://localhost:8001/manage/problem/update",
                type:"post",
                data:{
                    problemId,
                    title:title.value,
                    link:link.value,
                    tagId:tagId.value,
                },
                success(resp){
                    if(resp.message === "success"){
                        title.value = "";
                        link.value = "";
                        tagId.value = -1;
                        getProblemList();
                        Modal.getInstance("#updateProblem").hide();//关闭模态框
                    }else{
                        message.value = resp.message;
                    }
                },
                error(resp){
                    console.log(resp);
                }
            })
        }

        const deleteProblem = problemId => {
            $.ajax({
                url:"http://localhost:8001/manage/problem/delete",
                type:"post",
                data:{
                    problemId,
                },
                success(resp){
                    if(resp.message === "success"){
                        getProblemList();
                        Modal.getInstance("#deleteProblem").hide();
                    }else{
                        message.value = "删除失败"
                    }
                },
                error(resp){
                    console.log(resp);
                }
            })
        }

        return {
            tagList,
            problemList,
            nowTag,
            title,
            tagId,
            link,
            addProblem,
            message,
            toAdd,
            getProblemById,
            updateProblem,
            deleteProblem,
        }
    }
}
</script>

<style scoped>

</style>