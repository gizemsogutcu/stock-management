<template>
    <div class="container">
        <vue-confirm-dialog></vue-confirm-dialog>
        <router-view/>
    </div>
</template>

<script>
    export default {
        name: "app"
    };
</script>

<style>
    @import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>

