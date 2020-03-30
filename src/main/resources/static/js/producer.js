
function getIndex(list, id) {
  for (var i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return i;
    }
  }

  return -1;
}

var producerApi = Vue.resource('/producer{/id}');

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
    messageAttr: function (newVal, oldVal) {
      this.producerName = newVal.producerName;
      this.country = newVal.country;
      this.id = newVal.id;
    }
  },
  template:
      '<div>'
      + '<input type="text" placeholder="enter paint producer name" v-model="producerName" />'
      + '<input type="text" placeholder="enter producer contry" v-model="country" />'
      + '<input type="button" value="Save" @click="save"/>'
      + '</div>',
  methods: {
    save: function () {
      var producer = {
        producerName: this.producerName,
        country: this.country
      };

      if (this.id) {
        producerApi.update({id :this.id}, producer).then(result =>
            result.json().then(data => {
              var index = getIndex(this.message, data.id);
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
  props: ['producer', 'editMethod', 'producers'],
  template:
      '<div>'
      + '<i>({{producer.id}})</i>{{producer.producerName}}<i>{{producer.country}}</i>'
      + '<span style="position: absolute; right: 0">'
      + '<input type="button" value="Edit" @click="edit" />'
      + '<input type="button" value="X" @click="del" />'
      + '</span>'
      + '</div>',
  methods: {
    edit: function () {
      this.editMethod(this.producer);
    },
    del: function () {
      producerApi.remove({id: this.producer.id}).then(result => {
        if (result.ok) {
          this.producers.splice(this.producers.indexOf(this.producer), 1)
        }
      })
    }
  }
});

Vue.component('producers-list', {
  props: ['producers'],
  data: function () {
    return {
      producer: null
    }
  },
  template:
      '<div style="position: relative; width: 300px;">'
      + '<producer-form :producers="producers" :producerAttr="producer"/>'
      + '<producer-row v-for="producer in producers" :key="producer.id" :producer="producer" '
      + ':editMethod="editMethod" :producers="producers"/>'
      + '</div>',
  created: function () {
    producerApi.get().then(result =>
        result.json().then(data =>
            data.forEach(producer => this.producers.push(producer))
        )
    )
  },
  methods: {
    editMethod: function (producer) {
      this.producer = producer;
    }
  }
});

var app = new Vue({
  el: '#app',
  template: '<producers-list  :producers="producers" />',
  data: {
    producers: []
  }
});