<template>

    <v-card outlined>
        <v-card-title>
            List # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="BookId" v-model="item.bookId" :editMode="editMode" @change="change" />
            </div>
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
    name: 'ListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/lists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

