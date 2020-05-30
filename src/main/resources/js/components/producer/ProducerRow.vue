<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters>
      <v-col
          cols="6"
          sm="3"
      >
        <v-card
            class="pa-2"
            outlined
            tile
        >
          ({{producer.id}})
        </v-card>
      </v-col>
      <v-col
          cols="6"
          sm="3"
      >
        <v-card
            class="pa-2"
            outlined
            tile
        >
          {{producer.producerName}}
        </v-card>
      </v-col>
      <v-col
          cols="6"
          sm="3"
      >
        <v-card
            class="pa-2"
            outlined
            tile
        >
          {{producer.country}}
        </v-card>
      </v-col>
        <v-btn class="ma-2" color="primary" @click="edit">Edit</v-btn>
        <v-btn class="ma-2" color="error" @click="del">Delete</v-btn>
    </v-row>
  </v-container>
</template>

<script>

  export default {
    props: ['producer', 'editProducer', 'deleteProducer', 'producers'],
    methods: {
      edit() {
        this.editProducer(this.producer);
      },
      del() {
        this.deleteProducer(this.producer)
      }
    }
  }
</script>

<style>

</style>
