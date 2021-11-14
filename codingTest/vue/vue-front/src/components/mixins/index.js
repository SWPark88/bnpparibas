import axios from 'axios'

export default {
    methods: {
        goToLogin() {
            this.clearUser();
            this.$router.push('/login');
        },
        clearUser() {
            sessionStorage.removeItem('id');
        },
        saveUser(id) {
            if (id) sessionStorage.setItem('id', id);
        },
        loadUser() {
            return sessionStorage.getItem('id');
        },
        async signup(id, password) {
            const data = {
                id,
                password,
            }
            const response = await this.postApi('/api/signup', data);
            return response;
        },
        async login(id, password) {
            const data = {
                id,
                password,
            }
            const response = await this.postApi('/api/login', data);
            return response;
        },
        async searchbook(id, searchTitle) {
            const data = {
                id,
                searchTitle,
            }
            const response = await this.postApi('/api/searchbook', data);
            return response;
        },
        async history(id) {
            const param = {
                id
            }
            const response = await this.getApi('/api/history', param);
            return response;
        },
        async getApi(url, param) {
            try {
                const isProd = process.env.NODE_ENV === 'production'
                const response = await axios
                    .get(isProd ? `${url}` : `${process.env.VUE_APP_API_ROOT}${url}`, { params: param });
                return response.data
            } catch (error) {
                alert(error);
                return null;
            }
        },
        async postApi(url, data) {
            try {
                const isProd = process.env.NODE_ENV === 'production'
                const response = await axios
                    .post(isProd ? `${url}` : `${process.env.VUE_APP_API_ROOT}${url}`, data);
                return response.data
            } catch (error) {
                alert(error);
                return null;
            }
        },
    },
};
