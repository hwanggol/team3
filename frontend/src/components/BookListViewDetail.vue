<template>

    <v-card outlined>
        <v-card-title>
            BookList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="BookStatus" v-model="item.bookStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="BookName" v-model="item.bookName" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'BookListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/bookLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

