<template>
    <ContentComponent>
        <router-view/>
    </ContentComponent>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import ContentComponent from "@/components/ContentComponent";

export default {
    name: 'App',
    components: {
        ContentComponent
    }
}
</script>

<style>
body{
    background-image: url("./assets/backimg.jpg");
    background-size: cover;
}
</style>
