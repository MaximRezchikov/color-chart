<template>
  <v-data-table
      :headers="headers"
      :items="paint"
      :items-per-page="5"
      class="elevation-1"
  ></v-data-table>
</template>

<script>
  export default {
    name: "CommonTable",
    data() {
      return {
        headers: [
          {
            text: 'Paints',
            align: 'start',
            sortable: false,
            value: 'name'
          },
          {text: 'Name', value: 'calories'},
          {text: 'Company Number', value: 'serialNumber'},
        ]
      }
    }
  }
</script>

<style scoped>

</style>