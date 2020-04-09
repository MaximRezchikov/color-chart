<template>
  <div>
    <input type="text" placeholder="enter paint producer name" v-model="producerName"/>
    <input type="text" placeholder="enter producer country" v-model="country"/>
    <input type="button" value="Save" @click="save"/>
  </div>
</template>

<script>

  function getIndex(list, id) {
    for (let i = 0; i < list.length; i++) {
      if (list[i].id === id) {
        return i;
      }
    }

    return -1;
  }

  export default {
    props: ['producers', 'producerAttr'],
    data () {
      return {
        producerName: '',
        country: '',
        id: ''
      }
    },
    watch: {
      producerAttr (newVal, oldVal) {
        this.producerName = newVal.producerName;
        this.country = newVal.country;
        this.id = newVal.id;
      }
    },
    methods: {
      save () {
        const producer = {
          producerName: this.producerName,
          country: this.country
        };

        if (this.id) {
          this.$resource('/producer{/id}').update({id :this.id}, producer).then(result =>
              result.json().then(data => {
                const index = getIndex(this.producers, data.id);
                this.producers.splice(index, 1, data);
                this.producerName = '';
                this.country = '';
                this.id = '';
              })
          )
        } else {
          this.$resource('/producer{/id}').save({}, producer).then(result =>
              result.json().then(data => {
                this.producers.push(data);
                this.producerName = '';
                this.country = '';
              })
          )
        }
      }
    }
  }
</script>

<style>

</style>