<template>
  <v-card>
    <v-card-title>
      Paints
      <v-spacer></v-spacer>
      <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
        :headers="headers"
        :items="paintList"
        :search="search"
        :items-per-page="10"
        class="elevation-1"
    >
      <template v-slot:item.file.file="{item}">
        <v-img :src="'data:image/jpg||bmp||jpeg||png;base64,' + item.file.file" height="100" width="100"></v-img>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
  import axios from "axios";

  export default {
    name: "CommonTable",
    data() {

      return {
        search: '',
        headers: [
          {
            text: 'Paints',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          {text: 'Image', value: 'file.file'},
          {text: 'Company Number', value: 'companyColorNumber'},
          {text: 'Paint Serial Number', value: 'paintSerialNumber'},
          {text: 'Opacity', value: 'opacity'},
          {text: 'Lightfastness', value: 'lightfastness'},
          {text: 'Staining', value: 'staining'},
          {text: 'Granulation', value: 'granulation'},
          {text: 'Pigment', value: 'pigmentsFromSet'},
          {text: 'Producer', value: 'producer.producerName'},
        ],
        paintList: []
      }
    },
    mounted() {
      axios.get('http://localhost:8080/paint/withpigment')
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