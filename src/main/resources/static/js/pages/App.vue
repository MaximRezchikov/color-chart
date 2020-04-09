<template>
  <div>
    <div v-if="!profile">Google authorize
      <a href="/login">Google</a>
    </div>
    <div v-else>
      <div>{{profile.name}}&nbsp;
        <a href="/logout">LogOut</a>
      </div>
      <producers-list :producers="producers"/>
    </div>
  </div>
</template>

<script>
  import ProducersList from 'components/producer/ProducerList.vue'

  export default {
    components: {
      ProducersList
    },
    data() {
      return {
        producers: frontendData.producers,
        profile: frontendData.profile
      }
    }
  }
</script>

<style>

</style>