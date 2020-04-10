<template>
  <v-app>
    <v-app-bar app
               color="indigo"
               dark
    >
      <v-spacer>Color-Chart</v-spacer>
      <span v-if="profile">{{profile.name}}</span>
      <v-btn class="ma-2" dark v-if="profile" href="/logout">
        Exit
      </v-btn>
    </v-app-bar>
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>

  export default {
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