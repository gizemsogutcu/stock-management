import Vue from "vue";
import Router from "vue-router";

Vue.use(Router)

const router = new Router({
    mode: 'history', // Use browser history
    routes: [
        {
            path: "/",
            component: () => import("./components/Products"),
        },
        {
            path: "/products",
            component: () => import("./components/Products"),
        },
        {
            path: "/product/:id",
            component: () => import("./components/UpdateProduct")
        },
        {
            path: "/add-product",
            component: () => import("./components/AddProduct")
        }
    ]
});

export default router;
