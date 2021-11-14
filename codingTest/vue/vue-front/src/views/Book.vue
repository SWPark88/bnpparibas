<template>
  <div>
    <BookListForm @showBookDetailModal="showBookDetailModal" />
    <BookDetailModal ref="bookDetailModal" />
  </div>
</template>

<script>
import BookListForm from '@/components/BookListForm.vue';
import BookDetailModal from '@/components/BookDetailModal.vue';

export default {
  name: 'Book',
  components: {
    BookListForm,
    BookDetailModal,
  },
  methods: {
    showBookDetailModal(bookDetail) {
      this.$refs.bookDetailModal.showModal(bookDetail);
    }
  }
}
</script>
