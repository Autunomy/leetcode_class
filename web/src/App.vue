<template>
    <div>
        <router-view/>
    </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

export default {
    name: 'App',
    components: {
    }
}
</script>

<style>
body{
    background-image: url("./assets/backimg.jpg");
    background-size: cover;
}
</style>
