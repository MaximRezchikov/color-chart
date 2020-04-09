<template>
  <v-app>
    <v-app-bar app>
      <v-spacer>Color-Chart</v-spacer>
      <span v-if="profile">{{profile.name}}</span>
      <v-btn v-if="profile" icon href="/logout">
        Exit
      </v-btn>
    </v-app-bar>
    <v-content>
      <v-container v-if="!profile">
        Google authorize
        <a href="/login">Google</a>
      </v-container>
      <v-container v-if="profile">
        <producers-list :producers="producers"/>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
  import ProducersList from 'components/producer/ProducerList.vue'

  export default {
    components: {
      ProducersList
    },
    data() {
      return {
        profile: frontendData.profile,
        producers: frontendData.producers
      }
    }
  }
</script>

<style>

</style>