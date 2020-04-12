<template>
  <v-app>
    <v-app-bar app
               color="indigo"
               dark
    >
      <v-spacer>Color-Chart</v-spacer>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/'"
             @click="showHelloPage">
        Home Page
      </v-btn>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/producers'"
             @click="showProducers">
        Producers
      </v-btn>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/paints'"
             @click="showPaints">
        Paints
      </v-btn>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/table'"
             @click="showTable">
        Common Table
      </v-btn>
      <v-btn text
             v-if="profile"
             :disabled="$route.path === '/profile'"
             @click="showProfile">
        {{profile.name}}
      </v-btn>
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
      }
    },
    methods: {
      showHelloPage() {
        this.$router.push('/')
      },
      showProducers() {
        this.$router.push('/producers')
      },
      showPaints() {
        this.$router.push('/paints')
      },
      showProfile() {
        this.$router.push('/profile')
      },
      showTable() {
        this.$router.push('/table')
      }
    },
    beforeMount() {
      if (!this.profile) {
        this.$router.replace('/auth')
      }
    }
  }
</script>

<style>

</style>
