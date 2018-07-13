<template>
    <div id="Header">
      <div><span>用户名:{{ userName }}</span></div>
      <div><span>部门:{{ dept }}</span></div>
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
        'userName','dept'
      ]
    }
</script>

<style scoped>
  #Header {
    background-color: darkblue;
    color: white;
  }
</style>
