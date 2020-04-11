<template>
  <div>
    <v-form>
      <v-container>
        <v-row>
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
                label="Color"
                placeholder="Color"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="colorNumber"
                label="Color number"
                placeholder="Color number"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="serialNumber"
                type="number"
                label="Serial number"
                placeholder="Serial number"
                outlined></v-text-field>
          </v-col>
        </v-row>
        <v-btn class="ma-2" color="success" @click="save">Save</v-btn>
      </v-container>
    </v-form>
  </div>
</template>

<script>

  function getIndex(list, id) {
    for (let i = 0; i < list.length; i++) {
      if (list[i].id === id) {
        return i;
      }
    }

    return -1;
  }

  export default {
    props: ['paints', 'paintAttr'],
    data() {
      return {
        name: '',
        color: '',
        colorNumber: '',
        serialNumber: '',
        id: ''
      }
    },
    watch: {
      paintAttr (newVal, oldVal) {
        this.name = newVal.name;
        this.color = newVal.color;
        this.colorNumber = newVal.colorNumber;
        this.serialNumber = newVal.serialNumber;
        this.id = newVal.id;
      }
    },
    methods: {
      save() {
        const paint = {
          name: this.name,
          color: this.color,
          colorNumber: this.colorNumber,
          serialNumber: this.serialNumber
        };

        if (this.id) {
          this.$resource('/paint{/id}').update({id: this.id}, paint).then(result =>
              result.json().then(data => {
                let index = getIndex(this.paints, data.id);
                this.paints.splice(index, 1, data);
                this.name = '';
                this.color = '';
                this.colorNumber = '';
                this.serialNumber = '';
                this.id = '';
              })
          )
        } else {
          this.$resource('/paint{/id}').save({}, paint).then(result =>
              result.json().then(data => {
                this.paints.push(data);
                this.name = '';
                this.color = '';
                this.colorNumber = '';
                this.serialNumber = '';
              })
          )
        }
      }
    }
  }
</script>

<style scoped>

</style>
