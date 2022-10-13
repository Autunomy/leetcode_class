import {createRouter, createWebHistory} from 'vue-router'
import NotFound from "@/views/error/NotFound";
import ManageProblemView from "@/views/problem/ManageProblemView";

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
