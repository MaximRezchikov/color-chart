
let appGoogleAuth = new Vue({
  el: '#appGoogleAuth',
  template:
      '<div>'
      + '<div v-if="!profile">Google authorize <a href="/login">Google</a></div>'
        + '<div v-else>'
        + '<div>{{profile.name}}&nbsp;<a href="/logout">LogOut</a></div>'
        + '<div >Go to add producer <a href="/producer.html">Add producer</a></div>'
        + '</div>'
      + '</div>',
  data: {
    profile: frontendData.profile
  },
});