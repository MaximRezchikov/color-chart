
var producerApi = Vue.resource('/producer{/id}');

Vue.component('producer-row', {
  props: ['producer'],
  template: '<div><i>({{producer.id}})</i>{{producer.producerName}}<i>{{producer.country}}</i></div>'
});

Vue.component('producers-list', {
  props: ['producers'],
  template: '<div>'
      + '<producer-row v-for="producer in producers" :key="producer.id" :producer="producer">'
      + '</producer-row></div>',
  created: function () {
    producerApi.get().then(result =>
        result.json().then(data =>
            data.forEach(producer => this.producers.push(producer))
        )
    )
  }
});

var app = new Vue({
  el: '#app',
  template: '<producers-list  :producers="producers" />',
  data: {
    producers: []
  }
});