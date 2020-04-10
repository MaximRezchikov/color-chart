<template>
  <div>
    <producers-list :producers="producers"/>
  </div>
</template>

<script>
  import ProducersList from 'pages/ProducerList.vue'

  export default {
    components: {
      ProducersList
    },
    data() {
      return {
        producers: []
      }
    }
  }

</script>

<style>

</style>