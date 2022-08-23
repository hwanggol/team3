<template>

    <v-data-table
        :headers="headers"
        :items="list"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "bookId", value: "bookId" },
                { text: "bookStatus", value: "bookStatus" },
                { text: "bookName", value: "bookName" },
            ],
            list : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lists'))

            temp.data._embedded.lists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.list = temp.data._embedded.lists;
        },
        methods: {
        }
    }
</script>

