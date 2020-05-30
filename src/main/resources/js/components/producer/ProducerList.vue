<template>
  <v-container>
    <v-layout align-space-around justify-start column>
      <producer-form :producers="producers" :producerAttr="producer"/>
      <producer-row v-for="producer in producers"
                    :key="producer.id"
                    :producer="producer"
                    :editProducer="editProducer"
                    :deleteProducer="deleteProducer"
                    :producers="producers"/>
    </v-layout>
  </v-container>
</template>

<script>
  import axios from "axios"
  import ProducerRow from 'components/producer/ProducerRow.vue'
  import ProducerForm from 'components/producer/ProducerForm.vue'

  export default {
    props: ['producer'],
    components: {
      ProducerRow,
      ProducerForm,
    },
    data() {
      return {
        producers: ''
      }
    },
    mounted() {
      this.getProducers();
    },
    methods: {
      getProducers() {
        axios.get('http://localhost:8080/producer')
        .then(result => {
          this.producers = result.data
        }, error => {
          console.error(error)
        });
      },
      editProducer(producer) {
        this.producer = producer
      },
      deleteProducer(producer) {
        this.$resource('/producer{/id}').remove({id: producer.id}).then(result => {
          if (result.ok) {
            this.producers.splice(this.producers.indexOf(producer), 1)
          }
        })
      }
    }
  }

</script>

<style>

</style>
