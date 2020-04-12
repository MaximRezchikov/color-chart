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
          ({{paint.id}})
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
          {{paint.name}}
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
          {{paint.color}}
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
          {{paint.color}}
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
          {{paint.lightfastness}}
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
          {{paint.opacity}}
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
          {{paint.staining}}
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
          {{paint.granulation}}
        </v-card>
      </v-col>
      <v-btn class="ma-2" color="primary" @click="edit">Edit</v-btn>
      <v-btn class="ma-2" color="error" @click="del">Delete</v-btn>
    </v-row>
  </v-container>
</template>

<script>

  export default {
    props: ['paint', 'editPaint', 'deletePaint', 'paints'],
    methods: {
      edit() {
        this.editPaint(this.paint);
      },
      del() {
        this.deletePaint(this.paint)
      }
    }
  }
</script>

<style scoped>

</style>
