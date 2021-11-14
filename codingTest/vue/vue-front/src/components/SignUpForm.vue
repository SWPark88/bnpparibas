<template>
  <div>
    <div>
      <p>
        회원가입
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
        확인
        </a>
      </div>
    </div>
  </div>
</template>

<script>
  import mixins from '@/components/mixins/index.js';

  const data = { id: '', password: '' };

  export default {
    name: 'SignUpForm',
    mixins: [mixins],
    data() {
      return data;
    },
    async created() {
    },
    methods: {
      clearInput() {
        data.id = '';
        data.password = '';
      },
      async onClickSignUp() {
        if (!data.id || !data.password) {
          this.clearInput();
        }
        const result = await this.signup(data.id, data.password);
        if (!result) {
          this.clearInput();
          return;
        }
        this.$router.push('/login');
      },
    },
  };
</script>
