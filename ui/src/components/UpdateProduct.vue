<template>
    <div>
        <br/>
        <h3>Ürün Güncelle</h3>
        <br/>
        <div class="container">
            <form @submit="validateAndSubmit">
                <div v-if="errors.length">
                    <div class="alert alert-danger" v-bind:key="index" v-for="(error, index) in errors">{{error}}</div>
                </div>
                <fieldset class="form-group">
                    <label>Ad</label>
                    <input type="text" class="form-control" v-model="name" disabled>
                </fieldset>
                <fieldset class="form-group">
                    <label>Adet</label>
                    <input type="number" class="form-control" v-model="piece" required min="1">
                </fieldset>
                <fieldset class="form-group">
                    <label>Fiyat</label>
                    <input type="text" class="form-control" v-model="price" required
                           placeholder="10.25"
                           pattern="^[0-9]+(\.[0-9]{1,2})?$" title="Fiyat 10.25 formatında olmalıdır.">
                </fieldset>
                <button class="btn btn-success" type="submit">Güncelle</button>
            </form>
        </div>
    </div>
</template>

<script>
    import productService from "../service/ProductService";

    export default {
        name: "product",
        data() {
            return {
                name: "",
                piece: "",
                price: "",
                errors: []
            };
        },
        methods: {
            refreshProductDetails() {
                productService.getProductById(this.$route.params.id).then(res => {
                    debugger;
                    this.name = res.data.body.name;
                    this.piece = res.data.body.piece;
                    this.price = res.data.body.price;
                })
                    .then((res) => {
                        if(!res.data.success)
                            this.errors.push(res.data.errorMessage);
                    })
                    .catch((res) => {
                        this.errors.push(res.data.errorMessage);
                    })
            },
            validateAndSubmit(e) {
                e.preventDefault();
                productService.updateProduct({
                    id: this.$route.params.id,
                    name: this.name,
                    piece: this.piece,
                    price: this.price
                })
                    .then((res) => {
                        if(res.data.success)
                            this.$router.push('/Products');
                        else
                            this.errors.push(res.data.errorMessage);
                    })
                    .catch((res) => {
                        this.errors.push(res.data.errorMessage);
                    })
            }
        },
        created() {
            this.refreshProductDetails();
        }
    };

</script>

<style scoped>

</style>