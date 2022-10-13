<template>
    <div>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <router-link :class="route_name === 'manageProblem' ? 'nav-link active' : 'nav-link'"
                             :to="{name:'manageProblem'}">题目
                </router-link>
            </li>
            <li class="nav-item">
                <router-link
                    :class="route_name === 'manageTag' ? 'nav-link active' : 'nav-link'"
                    :to="{name:'manageTag'}">标签</router-link>
            </li>
            <li class="nav-item">
                <router-link
                    :class="route_name === 'manageContent' ? 'nav-link active' : 'nav-link'"
                    :to="{name:'manageContent'}">题解</router-link>
            </li>
        </ul>
    </div>
</template>

<script>
import {useRoute} from "vue-router";
import {computed} from "vue";

export default {
    name: "NavBar",
    setup() {
        const route = useRoute();
        let route_name = computed(() => route.name);


        return {
            route_name,
        }
    }
}
</script>

<style scoped>

</style>