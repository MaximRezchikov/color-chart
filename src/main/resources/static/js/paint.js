
function getIndex(list, id) {
  for (let i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return i;
    }
  }

  return -1;
}

let paintApi = Vue.resource('/paint{/id}');

Vue.component('paint-form', {
  props: ['paints', 'paintAttr'],
  data: function () {
    return {
      name: '',
      color : '',
      colorNumber: '',
      serialNumber: '',
      id: ''
    }
  },
  watch: {
    paintAttr: function (newVal, oldVal) {
      this.name = newVal.name;
      this.color = newVal.color;
      this.colorNumber = newVal.colorNumber;
      this.serialNumber = newVal.serialNumber;
      this.id = newVal.id;
    }
  },
  template:
      '<div>'
      + '<input type="text" placeholder="enter paint name" v-model="name" />'
      + '<input type="number" placeholder="enter color id" v-model="color" />'
      + '<input type="number" placeholder="enter color number" v-model="colorNumber" />'
      + '<input type="number" placeholder="enter serial color number" v-model="serialNumber" />'
      + '<input type="button" value="Save" @click="save"/>'
      + '</div>',
  methods: {
    save: function () {
      let paint = {
        name: this.name,
        color: this.color,
        colorNumber: this.colorNumber,
        serialNumber: this.serialNumber
      };

      if (this.id) {
        paintApi.update({id :this.id}, paint).then(result =>
            result.json().then(data => {
              let index = getIndex(this.paints, data.id);
              this.paints.splice(index, 1, data);
              this.name = '';
              this.color = '';
              this.colorNumber = '';
              this.serialNumber = '';
              this.id = '';
            })
        )
      } else {
        paintApi.save({}, paint).then(result =>
            result.json().then(data => {
              this.paints.push(data);
              this.name = '';
              this.color = '';
              this.colorNumber = '';
              this.serialNumber = '';
            })
        )
      }
    }
  }
});

Vue.component('paint-row', {
  props: ['paint', 'editMethod', 'paints'],
  template:
      '<div>'
      + '<i>({{paint.id}})</i>{{paint.name}}<i>{{paint.color}}</i>'
      + '<i>{{paint.colorNumber}}</i><i>{{paint.serialNumber}}</i>'
      + '<span style="position: absolute; right: 0">'
      + '<input type="button" value="Edit" @click="edit" />'
      + '<input type="button" value="X" @click="del" />'
      + '</span>'
      + '</div>',
  methods: {
    edit: function () {
      this.editMethod(this.paint);
    },
    del: function () {
      paintApi.remove({id: this.paint.id}).then(result => {
        if (result.ok) {
          this.paints.splice(this.paints.indexOf(this.paint), 1)
        }
      })
    }
  }
});

Vue.component('paints-list', {
  props: ['paints'],
  data: function () {
    return {
      paint: null
    }
  },
  template:
      '<div style="position: relative; width: 300px;">'
      + '<paint-form :paints="paints" :paintAttr="paint"/>'
      + '<paint-row v-for="paint in paints" :key="paint.id" :paint="paint" '
      + ':editMethod="editMethod" :paints="paints"/>'
      + '</div>',
  created: function () {
    paintApi.get().then(result =>
        result.json().then(data =>
            data.forEach(paint => this.paints.push(paint))
        )
    )
  },
  methods: {
    editMethod: function (paint) {
      this.paint = paint;
    }
  }
});

let appPaint = new Vue({
  el: '#appPaint',
  template: '<paints-list  :paints="paints" />',
  data: {
    paints: []
  }
});