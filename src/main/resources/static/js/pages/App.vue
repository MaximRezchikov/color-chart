<template>
  <div>
    <div v-if="!profile">Google authorize
      <a href="/login">Google</a>
    </div>
    <div v-else>
      <div>{{profile.name}}&nbsp;
        <a href="/logout">LogOut</a>
      </div>
      <div>Go to add producer
        <a href="/producer.html">Add producer</a>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        profile: frontendData.profile
      }
    }
  }
</script>

<style>

</style>