<template>
    <div>
      <p>{{ headerMsg }}</p>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
          return {
          }
        },
      props: [
        'headerMsg'
      ]
    }
</script>

<style scoped>

</style>
