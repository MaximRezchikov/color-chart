import Vue from 'vue';
import VueResource from 'vue-resource';
import Producer from 'pages/Producer.vue';

Vue.use(VueResource);

new Vue({
  el: '#appProd',
  render: a => a(Producer)
});

/*

function getIndex(list, id) {
  for (let i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return i;
    }
  }

  return -1;
}

let producerApi = Vue.resource('/producer{/id}');

Vue.component('producer-form', {
  props: ['producers', 'producerAttr'],
  data: function () {
    return {
      producerName: '',
      country: '',
      id: ''
    }
  },
  watch: {
    producerAttr: function (newVal, oldVal) {
      this.producerName = newVal.producerName;
      this.country = newVal.country;
      this.id = newVal.id;
    }
  },
  methods: {
    save: function () {
      let producer = {
        producerName: this.producerName,
        country: this.country
      };

      if (this.id) {
        producerApi.update({id :this.id}, producer).then(result =>
            result.json().then(data => {
              let index = getIndex(this.producers, data.id);
              this.producers.splice(index, 1, data);
              this.producerName = '';
              this.country = '';
              this.id = '';
            })
        )
      } else {
        producerApi.save({}, producer).then(result =>
            result.json().then(data => {
              this.producers.push(data);
              this.producerName = '';
              this.country = '';
            })
        )
      }
    }
  }
});

Vue.component('producer-row', {

});

Vue.component('producers-list', {

});*/
