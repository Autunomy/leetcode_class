<template>
    <ContentComponent>
        <NavBar></NavBar>
        <br>
        <router-view/>
    </ContentComponent>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import ContentComponent from "@/components/ContentComponent";
import NavBar from "@/components/NavBar";

export default {
    name: 'App',
    components: {
        ContentComponent,
        NavBar,
    }
}
</script>

<style>
body{
    background-image: url("./assets/backimg.jpg");
    background-size: cover;
}
</style>
