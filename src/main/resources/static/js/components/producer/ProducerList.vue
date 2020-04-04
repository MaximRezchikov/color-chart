<template>
  <div style="position: relative; width: 300px;">
    <!--    <producer-form :producers="producers" :producerAttr="producer"/>-->
    <producer-row v-for="producer in producers"
                  :key="producer.id"
                  :producer="producer"
                  :editProducer="editProducer"
                  :deleteProducer="deleteProducer"
                  :producers="producers"/>
  </div>
</template>

<script>
  import ProducerRow from 'components/producer/ProducerRow.vue'



  export default {
    props: ['producers'],
    components: {
      ProducerRow
    },
    data() {
      return {
        producer: null
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
</script>

<style>

</style>