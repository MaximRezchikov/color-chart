<template>
  <v-container>
    <picture-input
        ref="picture"
        @change="onChanged"
        @remove="onRemoved"
        :width="400"
        :removable="true"
        removeButtonClass="ui red button"
        :height="200"
        accept="image/jpeg, image/png, image/gif"
        buttonClass="ui button primary"
        :custom-string="{
  upload: '<h1>Upload it!</h1>',
  drag: 'Drag and drop your image here'
  }">
    </picture-input>
    <button @click="attemptUpload" v-bind:class="{ disabled: !picture }">
      Upload
    </button>
  </v-container>
</template>

<script>
  import PictureInput from 'vue-picture-input'
  import FormDataPost from './upload.js'

  export default {
    name: "Picture",
    data() {
      return {
        picture: ''
      }
    },
    components: {
      PictureInput
    },
    methods: {
      onChanged() {
        console.log("New picture loaded");
        if (this.$refs.picture.file) {
          this.picture = this.$refs.picture.file;
        } else {
          console.log("Old browser. No support for Filereader API");
        }
      },
      onRemoved() {
        this.picture = '';
      },
      attemptUpload() {
        if (this.picture) {
          FormDataPost('http://localhost:8080/picture', this.picture)
          .then(response => {
            if (response.data.success) {
              this.picture = '';
              console.log("Image uploaded successfully");
            }
          })
          .catch(err => {
            console.error(err);
          });
        }
      }
    }
  }

</script>

<style scoped>

</style>