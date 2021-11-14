<template>
  <div>
    <div>
      <p>
        로그인
      </p>
    </div>
    <div>
      <div>
        <div>
          <p>ID</p>
        </div>
        <input
          v-model="id"
          type="text"
          placeholder="ID를 입력해주세요."
        >
      </div>

      <div>
        <div>
          <p>Password</p>
        </div>
        <input
          v-model="password"
          type="password"
          placeholder="Password를 입력해주세요."
        >
      </div>
      <div>
        <a
        href="#"
        @click="onClickSignUp()"
        >
        회원가입
        </a>
        <p/>
        <a
        href="#"
        @click="onClickLogin()"
        >
        로그인
        </a>
      </div>
    </div>
  </div>
</template>

<script>
  import mixins from '@/components/mixins/index.js';

  const data = { id: '', password: '' };

  export default {
    name: 'LoginForm',
    mixins: [mixins],
    data() {
      return data;
    },
    created() {
      this.clearUser();
    },
    methods: {
      clearInput() {
        data.id = '';
        data.password = '';
      },
      onClickSignUp() {
        this.$router.push('/sign-up');
      },
      async onClickLogin() {
        if (!data.id || !data.password) {
          this.clearInput();
        }
        const result = await this.login(data.id, data.password);
        if (!result) {
          this.clearInput();
          return;
        }
        this.saveUser(result.id);
        this.$router.push('/book');
      },
    },
  };
</script>
