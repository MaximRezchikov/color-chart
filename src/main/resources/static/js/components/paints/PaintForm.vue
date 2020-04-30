<template>
  <div>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="pictureNameList"
                :search-input.sync="pictureName"
                color="green"
                label="Picture Name"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="name"
                label="Paint"
                placeholder="Paint"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="color"
                type="number"
                label="ColorHex"
                placeholder="Color"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="companyColorNumber"
                label="Company Color number"
                placeholder="Color number"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="paintSerialNumber"
                type="number"
                label="Serial number"
                placeholder="1, 2, 3"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="lightfastnessList"
                :search-input.sync="lightfastness"
                color="green"
                label="Lightfastness"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="opacityList"
                :search-input.sync="opacity"
                color="green"
                label="Opacity"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="stainingList"
                :search-input.sync="staining"
                color="green"
                label="Staining"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="granulationList"
                :search-input.sync="granulation"
                color="green"
                label="Granulation"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="producerNameList"
                :search-input.sync="producerName"
                color="green"
                label="Producer Name"
                outlined
            ></v-autocomplete>
          </v-col>
        </v-row>
        <v-btn class="ma-2" color="success" @click="save">Save paint</v-btn>
        <v-row>
          <v-col cols="10" sm="5">
            <v-autocomplete
                :items="paintNameList"
                :search-input.sync="paintName"
                color="green"
                label="Paint"
                outlined
            ></v-autocomplete>
          </v-col>
          <v-col cols="10" sm="5">
            <v-select
                v-model="pigmentIndexes"
                :items="pigmentList"
                multiple
                color="green"
                label="Pigment"
                outlined
            ></v-select>
          </v-col>
        </v-row>
        <v-btn class="ma-2" color="success" @click="addPigments(paintName, pigmentIndexes)">Add pigment</v-btn>
      </v-container>
    </v-form>
  </div>
</template>

<script>

  import axios from "axios";

  function getIndex(list, id) {
    for (let i = 0; i < list.length; i++) {
      if (list[i].id === id) {
        return i;
      }
    }

    return -1;
  }

  export default {
    props: ['paints', 'paintAttr', 'pigmentAttr'],
    data() {
      return {
        name: '',
        color: '',
        companyColorNumber: '',
        paintSerialNumber: '',
        lightfastnessList: ['nr', 'L0', 'L1', 'L2', 'L3', 'L4', 'L5'],
        opacityList: ['nr', 'O1', 'O2', 'O3', '04'],
        stainingList: ['nr', 'S1', 'S2', 'S3'],
        granulationList: ['nr', 'G'],
        lightfastness: '',
        opacity: '',
        staining: '',
        granulation: '',
        producerNameList: [],
        producerName: '',
        paintNameList: [],
        paintName: '',
        pigmentList: [],
        pigmentIndexes: [],
        pictureNameList: [],
        pictureName:'',
        id: '',
      }
    },

    mounted() {
      axios.get('http://localhost:8080/producer/names')
      .then(result => {
        this.producerNameList = result.data
      }, error => {
        console.error(error);
      });
      axios.get('http://localhost:8080/pigment/pgindexes')
      .then(result => {
        this.pigmentList = result.data
      }, error => {
        console.error(error);
      });
      axios.get('http://localhost:8080/paint/names')
      .then(result => {
        this.paintNameList = result.data
      }, error => {
        console.error(error);
      });
      axios.get('http://localhost:8080/picture/names')
      .then(result => {
        this.pictureNameList = result.data
      }, error => {
        console.error(error);
      });
    },

    watch: {
      paintAttr(newVal, oldVal) {
        this.name = newVal.name;
        this.color = newVal.color;
        this.companyColorNumber = newVal.paintSerialNumber;
        this.paintSerialNumber = newVal.serialNumber;
        this.lightfastness = newVal.lightfastness;
        this.opacity = newVal.opacity;
        this.staining = newVal.staining;
        this.granulation = newVal.granulation;
        this.producerName = newVal.producerName;
        this.pictureName = newVal.pictureName;
        this.id = newVal.id;
      },
      pigmentAttr(newVal, oldVal) {
        this.pigmentIndexes = newVal.pigmentIndexes;
      }
    },
    methods: {
      save() {
        const paint = {
          name: this.name,
          color: this.color,
          companyColorNumber: this.companyColorNumber,
          paintSerialNumber: this.paintSerialNumber,
          lightfastness: this.lightfastness,
          opacity: this.opacity,
          staining: this.staining,
          granulation: this.granulation,
          producerName: this.producerName,
          pictureName: this.pictureName
        };

        if (this.id) {
          this.$resource('/paint{/id}').update({id: this.id}, paint).then(result =>
              result.json().then(data => {
                let index = getIndex(this.paints, data.id);
                this.paints.splice(index, 1, data);
                this.name = '';
                this.color = '';
                this.companyColorNumber = '';
                this.paintSerialNumber = '';
                this.lightfastness = '';
                this.opacity = '';
                this.staining = '';
                this.granulation = '';
                this.producerName = '';
                this.id = '';
                this.pictureName = '';
              })
          )
        } else {
          this.$resource('/paint{/id}').save({}, paint).then(result =>
              result.json().then(data => {
                this.paints.push(data);
                this.name = '';
                this.color = '';
                this.companyColorNumber = '';
                this.paintSerialNumber = '';
                this.lightfastness = '';
                this.opacity = '';
                this.staining = '';
                this.granulation = '';
                this.producerName = '';
                this.pictureName = '';
              })
          )
        }
      },

      addPigments(paintName, pigmentIndexes) {
        axios.post('http://localhost:8080/paint/' + paintName + '/pigment', {
          pigmentIndexes: pigmentIndexes
        });
        this.paintName = '';
        this.pigmentIndexes = '';
      }
    }
  }
</script>

<style scoped>

</style>
