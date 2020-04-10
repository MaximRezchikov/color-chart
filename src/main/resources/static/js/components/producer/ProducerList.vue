<template>
  <v-layout align-space-around justify-start column>
    <producer-form :producers="producers" :producerAttr="producer"/>
    <producer-row v-for="producer in sortedProducers"
                  :key="producer.id"
                  :producer="producer"
                  :editProducer="editProducer"
                  :deleteProducer="deleteProducer"
                  :producers="producers"/>
  </v-layout>
</template>

<script>
  import ProducerRow from 'components/producer/ProducerRow.vue'
  import ProducerForm from 'components/producer/ProducerForm.vue'

  export default {
    props: ['producers'],
    components: {
      ProducerRow,
      ProducerForm
    },
    data() {
      return {
        producer: null
      }
    },
    computed: {
      sortedProducers() {
        return this.producers.sort(sortByName)
      }
    },
    methods: {
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
  let sortByName = function (a, b) {
    return (a.producerName.toLowerCase() > b.producerName.toLowerCase()) ? 1 : -1
  }

</script>

<style>

</style>