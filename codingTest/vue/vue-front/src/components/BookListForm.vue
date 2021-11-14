<template>
  <div>
    <div class="serches">
      <p>책검색</p>
      <div>
        <div class="dropdown-container in-bl" style="margin: 0px auto; width: 15rem;">
          <div style="width: 15rem;">
            <input v-model="searchTitle" @focus="isShown = true" placeholder="제목" class="input-box" style="height: 2rem; width: 15rem;">
          </div> 
          <div v-show="isShown" class="dropdown-inner" style="width: 15rem;">
            <div v-show="historyList.length > 0" class="item">
              <p @click="isShown = false;" class="non-active" style="width: 15rem;">
                최근 검색어
              </p>
            </div>
            <div v-for="(item,index) in historyList" :key="index" class="item">
              <p @click="searchTitle = item.title; isShown = false;" class="non-active" style="width: 15rem;">
                {{ item.title + " " + item.time }}
              </p>
            </div>
            <div v-show="favoriteList.length > 0" class="item">
              <p @click="isShown = false;" class="non-active" style="width: 15rem;">
                인기 검색어
              </p>
            </div>
            <div v-for="(item,index) in favoriteList" :key="index" class="item">
              <p @click="searchTitle = item.title; isShown = false;" class="non-active" style="width: 15rem;">
                {{ item.title + " " + item.count }}
              </p>
            </div>
          </div>
        </div>

        <button @click="onClickSearchBook(); isShown = false;">검색</button>
      </div>
    </div>
    <div style="margin-top: 50px;">
      <p>검색 결과</p>
      <smart-pagination
        :current-page.sync="currentPage"
        :total-pages="totalPages"
        :max-page-links="5"
      />
      <v-table
        :data="bookDataList"
        :current-page.sync="currentPage"
        :page-size="pageSize"
      >
        <thead slot="head">
          <tr>
            <th>제목</th>
            <th>소개</th>
            <th>저자</th>
            <th>출판사</th>
            <th>정가</th>
            <th>판매가</th>
          </tr>
        </thead>
        <tbody
          slot="body"
          slot-scope="{ displayData }"
        >
          <tr
            v-for="(row, index) in displayData"
            :key="index"
          >
            <td>
              <a
                href=""
                onclick="return false;"
                class="blue-1"
                @click="onClickBookDetail(row)"
              >
                {{ row.title }}
              </a>
            </td>
            <td>{{ row.contents }}</td>
            <td>{{ row.authors ? row.authors.join(',') : '' }}</td>
            <td>{{ row.publisher }}</td>
            <td>{{ row.price }}</td>
            <td>{{ row.sale_price > 0 ? row.sale_price : '' }}</td>
          </tr>
        </tbody>
      </v-table>
    </div>
  </div>
</template>

<script>
  import mixins from '@/components/mixins/index.js';

  export default {
    name: 'BookListForm',
    mixins: [mixins],
    components: {},
    data() {
      return {
        id: '',
        currentPage: 1,
        totalPages: 0,
        pageSize: 5,
        searchTitle: '',
        bookList: [],
        isShown: false,
        historyList: [],
        favoriteList: [],
      };
    },
    async created() {
      this.id = this.loadUser();
      if (!this.id) {
        this.$router.push('/login');
      }
      const result = await this.history(this.id);
      if (!result || !result.history) {
        return;
      }
      this.historyList = result.history;
      this.favoriteList = result.favorite;
    },
    computed: {
      bookDataList() {
        if (!this.bookList) {
          return [];
        }
        return this.bookList;
      },
    },
    methods: {
      async onClickSearchBook() {
        const result = await this.searchbook(this.id, this.searchTitle);
        if (!result || !result.documents) {
          return;
        }
        this.bookList = result.documents;
        this.totalPages = Math.ceil(this.bookList.length / this.pageSize);

        const result2 = await this.history(this.id);
        if (!result2 || !result2.history) {
          return;
        }
        this.historyList = result2.history;
        this.favoriteList = result2.favorite;
      },
      picked(searchTitle) {
        this.searchTitle = searchTitle;
      },
      onClickBookDetail(bookDetail) {
        this.$emit('showBookDetailModal', bookDetail);
      },
    },
  };
</script>

<style>
table {
  border-collapse: collapse;
  font-size: 12px;
  width: 100%;
}
th {
  background: #8c8c8c;
  border: 1px solid #E5E5E5;
}
td {
  border: 1px solid #E5E5E5;
}
.blue-1 {
  color: blue;
}
ol, ul{
  list-style: none;
}
.smart-pagination ul.pagination{
  display: flex;
}
.smart-pagination ul.pagination li.page-item a.page-link{
  display:block;
  width:26px;
  height:26px;
}
.active, .non-active {
  padding-top: 5px;
  padding-bottom: 5px;
}
.in-bl {
  display: inline-block;
}
</style>