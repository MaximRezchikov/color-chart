<template>
  <v-container>
    <v-layout align-space-around justify-start column>
      <paint-form :paints="paints" :paintAttr="paint"/>
      <paint-row v-for="paint in paints"
                    :key="paint.id"
                    :paint="paint"
                    :editPaint="editPaint"
                    :deletePaint="deletePaint"
                    :paints="paints"/>
    </v-layout>
  </v-container>
</template>

<script>
  import axios from "axios"
  import PaintRow from 'components/paints/PaintRow.vue'
  import PaintForm from 'components/paints/PaintForm.vue'


  export default {
    props: ['paint'],
    components: {
      PaintRow,
      PaintForm
    },
    data() {
      return {
        paints: ''
      }
    },
    mounted() {
      this.getPaints()
    },
    methods: {
      getPaints() {
        axios.get('http://localhost:8080/paint')
        .then(result => {
          this.paints = result.data
        }, error => {
          console.error(error);
        });
      },
      editPaint(paint) {
        this.paint = paint
      },
      deletePaint(paint) {
        this.$resource('/paint{/id}').remove({id: paint.id}).then(result => {
          if (result.ok) {
            this.paints.splice(this.paints.indexOf(paint), 1)
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
