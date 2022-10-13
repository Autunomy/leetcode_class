import {createRouter, createWebHistory} from 'vue-router'
import NotFound from "@/views/error/NotFound";
import ManageProblemView from "@/views/problem/ManageProblemView";
import ManageTagView from "@/views/tag/ManageTagView";
import ManageContentView from "@/views/content/ManageContentView";
import AddContentView from "@/views/content/AddContentView";

const routes = [
    {
        path: "/",
        name: "home",
        redirect: "/manage/problem",
    },
    {
        path:"/manage/problem",
        name:"manageProblem",
        component: ManageProblemView,
    },
    {
        path: "/manage/tag",
        name:"manageTag",
        component: ManageTagView,
    },
    {
        path: "/manage/content",
        name:"manageContent",
        component: ManageContentView,
    },
    {
        path: "/manage/content/add/:problemId",
        name: "addContent",
        component: AddContentView,
    },
    {
        path: "/404/",
        name: "404",
        component: NotFound,
    },
    {
        path:"/:catchAll(.*)",
        redirect:"/404/",
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
