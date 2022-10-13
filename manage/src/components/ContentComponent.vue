<template>
    <div class="row justify-content-md-center content">
        <div class="col-10">
            <div class="card">
                <div class="card-body">
                    <slot></slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ContentComponent"
}
</script>

<style scoped>
.content{
    margin-top: 20px;
}
</style>