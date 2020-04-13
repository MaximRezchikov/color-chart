<template>
<!--  <div>-->
<!--    <div v-for="(item) in paintList">{{item.name}}</div>-->
<!--  </div>-->
  <v-data-table
      :headers="headers"
      :items="paintList"
      :items-per-page="5"
      class="elevation-1"
  ></v-data-table>
</template>

<script>
  import axios from "axios";

  export default {
    name: "CommonTable",
    data() {

      return {
        headers: [
          {
            text: 'Paints',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: 'Company Number', value: 'companyColorNumber' },
          { text: 'Paint Serial Number', value: 'paintSerialNumber' },
          { text: 'Opacity', value: 'opacity' },
          { text: 'Lightfastness', value: 'lightfastness' },
          { text: 'Staining', value: 'staining' },
          { text: 'Granulation', value: 'granulation' },
          { text: 'Producer', value: 'producer.producerName' }
        ],
        paintList: []
      }
    },
    mounted() {
      axios.get('http://localhost:8080/paint')
      .then(result => {
        this.paintList = result.data
      }, error => {
        console.error(error);
      });
    },
    methods: {}
  }


</script>

<style scoped>

</style>