<template>
  <div>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="producerName"
                label="Producer"
                placeholder="Paint producer"
                outlined></v-text-field>
          </v-col>
          <v-col cols="10" sm="5">
            <v-text-field
                v-model="country"
                label="Country"
                placeholder="Producer country"
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
    props: ['producers', 'producerAttr'],
    data() {
      return {
        producerName: '',
        country: '',
        id: ''
      }
    },
    watch: {
      producerAttr(newVal, oldVal) {
        this.producerName = newVal.producerName;
        this.country = newVal.country;
        this.id = newVal.id;
      }
    },
    methods: {
      save() {
        const producer = {
          producerName: this.producerName,
          country: this.country
        };

        if (this.id) {
          this.$resource('/producer{/id}').update({id: this.id}, producer).then(result =>
              result.json().then(data => {
                const index = getIndex(this.producers, data.id);
                this.producers.splice(index, 1, data);
                this.producerName = '';
                this.country = '';
                this.id = '';
              })
          )
        } else {
          this.$resource('/producer{/id}').save({}, producer).then(result =>
              result.json().then(data => {
                this.producers.push(data);
                this.producerName = '';
                this.country = '';
              })
          )
        }
      }
    }
  }
</script>

<style>

</style>
