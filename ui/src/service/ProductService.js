import axios from 'axios'

const API_URL = 'http://localhost:8080/product'

export default {
    getAllProducts() {
        debugger;
        return axios.get(`${API_URL}/all`);
    },
    getProductById(id) {
        debugger;
        return axios.get(`${API_URL}/${id}`);
    },
    deleteProduct(id) {
        debugger;
        return axios.delete(`${API_URL}/delete/${id}`);
    },
    updateProduct(product) {
        debugger;
        return axios.post(`${API_URL}/update`, product);
    },
    addProduct(product) {
        debugger;
        return axios.post(`${API_URL}/add`, product);
    }
}




