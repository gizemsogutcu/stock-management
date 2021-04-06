<template>
    <div class="container">
        <br/>
        <h3>Ürünler</h3>
        <br/>
        <div v-if="message" class="alert alert-success">{{this.message}}</div>
        <div class="container">
            <table class="table">
                <tr>
                    <th>Ürün No</th>
                    <th>Ad</th>
                    <th>Adet</th>
                    <th>Tutar</th>
                    <th>Toplam</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr v-for="product in products" v-bind:key="product.id" v>
                    <td>{{product.id}}</td>
                    <td>{{product.name}}</td>
                    <td>{{product.piece}}</td>
                    <td>{{product.price}} ₺</td>
                    <td>{{total(product)}} ₺</td>
                    <td></td>
                    <td><button class="btn btn-warning" v-on:click="updateProduct(product.id)">Güncelle</button></td>
                    <td><button class="btn btn-danger" v-on:click="deleteProduct(product.id, product.name)">Sil</button></td>
                </tr>

            </table>
            <div class="row">
                <button class="btn btn-success" v-on:click="addProduct()">Ürün Ekle</button>
            </div>
        </div>
    </div>
</template>

<script>
    import productService from '../service/ProductService';

    export default {
        name: 'Products',

        data () {
            return {
                response: [],
                errors: [],
                message: "",
                products: {},
                totals: []
            }
        },
        methods: {
            refreshProducts () {
                productService.getAllProducts().then(res => {
                    debugger;
                    this.products = res.data.body;
                    this.totals = res.data.body.piece * res.data.body.price;
                })
                    .catch(e => {
                        debugger;
                        this.errors.push(e)
                    })
            },
            deleteProduct (id, name) {
                this.$confirm(
                    {
                        message: name + " ürününü silmek istediğinize emin misiniz?",
                        button: {
                            no: 'Hayır',
                            yes: 'Evet'
                        },
                        callback: confirm => {
                            if (confirm) {
                                productService.deleteProduct(id)
                                    .then(() => {
                                        this.refreshProducts();
                                    });
                            }
                        }
                    }
                )
            },
            updateProduct (id) {
                debugger;
                this.$router.push(`/product/${id}`);
            },
            addProduct () {
                this.$router.push(`/add-product`);
            },
            total(product) {
                return product.piece * product.price;
            }
        },
        created() {
            this.refreshProducts();
        }
    }

</script>

<style scoped>

</style>