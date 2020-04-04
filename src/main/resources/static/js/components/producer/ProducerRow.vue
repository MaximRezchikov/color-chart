<template>
  '
  <div>
    <i>({{producer.id}})</i>{{producer.producerName}}<i>{{producer.country}}</i>
    <span style="position: absolute; right: 0">
      <input type="button" value="Edit" @click="edit"/>
      <input type="button" value="X" @click="del"/>
      </span>
  </div>
</template>

<script>
  export default {
    props: ['producer', 'editProducer', 'deleteProducer', 'producers'],
    methods: {
      edit() {
        this.editProducer(this.producer);
      },
      del() {
        this.deleteProducer(this.producer)
      }
    }
  }
</script>

<style>

</style>