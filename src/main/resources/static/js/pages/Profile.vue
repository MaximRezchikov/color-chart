<template>
  <v-container>
    <v-layout justyfy-space-around>
      <v-flex>
        <div>User profile</div>
        <v-layout row justify-space-between>
          <v-flex>
            <v-img :src="prodile.userpic"></v-img>
          </v-flex>
        </v-layout>
      </v-flex>

    </v-layout>
    profile
  </v-container>
</template>

<script>
  export default {
    name: 'Profile'
  }
</script>

<style>

</style>