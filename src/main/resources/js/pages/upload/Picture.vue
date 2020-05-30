<template>
  <v-container>
    <v-card-title>
      Upload your picture
    </v-card-title>
    <v-spacer></v-spacer>
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
    <div>
      <v-btn class="ma-2" color="primary" @click="attemptUpload" v-bind:class="{ disabled: !picture }">
        Upload
      </v-btn>
    </div>
    <v-card
        class="mx-auto"
        max-width="200"
        outlined
        tile
        v-for="item in pictureList" :key="item.picture"
    >
      <v-img :src="'data:image/jpg||bmp||jpeg||png;base64,' + item.picture" height="100" width="200"></v-img>
      <v-card-title>{{item.name}}</v-card-title>
      <v-btn class="ma-2" color="primary" @click="removePicture(item)">Delete</v-btn>
      <v-spacer></v-spacer>
    </v-card>
  </v-container>
</template>

<script>
  import axios from "axios"
  import PictureInput from 'vue-picture-input'
  import FormDataPost from './upload.js'

  export default {
    name: "Picture",
    data() {
      return {
        name: '',
        picture: '',
        pictureList: []
      }
    },
    components: {
      PictureInput
    },
    mounted() {
      this.getPictures()
    },
    methods: {
      getPictures() {
        axios.get('http://localhost:8080/picture')
        .then(result => {
          this.pictureList = result.data
        }, error => {
          console.error(error);
        });
      },
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
            this.pictureList.push(this.getPictures());
            this.picture = '';
          })
          .catch(err => {
            console.error(err);
          });
        }
      },
      removePicture(item) {
        const index = this.pictureList.indexOf(item);
        if (confirm('Are you sure you want to delete this picture?') && this.pictureList.splice(index, 1)) {
          axios.delete('http://localhost:8080/picture/' + item.id, {
            picture: this.pictureList.picture
          })
        }
      }
    }
  }

</script>

<style scoped>

</style>