<template>
  <v-content>
    <v-container fill-height>
      <v-card-text>
        <input class="v-input" type="file" id="file" ref="picture" v-on:change="handleFileUpload()"/>
      </v-card-text>
        <v-btn rounded color="primary" v-on:click="submitFile()">Submit</v-btn>
    </v-container>
  </v-content>
</template>

<script>

  import axios from "axios";

  export default {
    name: "Picture",
    data() {
      return {
        file: ''
      }
    },

    methods: {
      submitFile() {

        let formData = new FormData();

        formData.append('file', this.file);

        axios.post('/file',
            formData,
            {
              headers: {
                'Content-Type': 'multipart/form-data'
              }
            }
        ).then(function () {
          console.log('SUCCESS!!');
        })
        .catch(function () {
          console.log('FAILURE!!');
        });
      },

      handleFileUpload() {
        this.file = this.$refs.file.files[0];
      }
    }
  }
</script>

<style scoped>

</style>