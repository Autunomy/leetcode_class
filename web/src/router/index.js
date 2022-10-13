import {createRouter, createWebHistory} from 'vue-router'
import NotFound from "@/views/error/NotFound";
import ProblemContentView from "@/views/problem/ProblemContentView";
import ContentListView from "@/views/content/ContentListView";
import ShowContentView from "@/views/content/ShowContentView";

const routes = [
    {
        path: "/",
        name: "home",
        redirect: "/problem",
    },
    {
        path: "/problem",
        name: "problem",
        component: ProblemContentView
    },
    {
        path: "/content/list/:problemId",
        name: 'contentList',
        component: ContentListView,
    },
    {
        path:"/content/show/:contentId",
        name:"showContent",
        component: ShowContentView,
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
