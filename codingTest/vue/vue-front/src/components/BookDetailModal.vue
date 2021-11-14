<template>
  <div
    v-if="isShown"
    class="modal"
  >
    <div
      class="close-modal"
      @click="closeModal"
    />
    <div class="wrap-modal">
      <table>
        <tr v-for="(item,index) in bookDetail"
          :key="index">
          <th>
            {{ item.title }}
          </th>
          <td>
            {{ item.text }}
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookDetailModal',
  data() {
    return {
      isShown: false,
      bookDetail: []
    }
  },
  methods: {
    closeModal() {
      this.isShown = false;
    },
    showModal(bookDetail) {
      this.bookDetail = [
        {title: '제목', text: bookDetail.title},
        {title: '도서 썸네일', text: bookDetail.thumbnail},
        {title: '소개', text: bookDetail.contents},
        {title: 'ISBN', text: bookDetail.isbn},
        {title: '저자', text: bookDetail.authors ? bookDetail.authors.join(',') : ''},
        {title: '출판사', text: bookDetail.publisher},
        {title: '출판일', text: bookDetail.datetime},
        {title: '정가', text: bookDetail.price > 0 ? bookDetail.price : ''},
        {title: '판매가', text: bookDetail.sale_price > 0 ? bookDetail.sale_price : ''},
      ];
      this.isShown = true;
    }
  }

}
</script>

<style scoped>
.modal {
  background: rgba(0, 0, 0, 0.3);
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}
.modal .close-modal {
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  position: absolute;
}
.modal .wrap-modal {
  max-width: 1100px;
  min-width: 700px;
  background-color: #ffffff;
}
th {
  background: #8c8c8c;
  border: 1px solid #E5E5E5;
  font-size: 20px;
  width: 150px;
}
td {
  border: 1px solid #E5E5E5;
}
</style>