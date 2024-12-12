<template>
  <div id="app">
    <h1>Random Activity App</h1>>
    <RandomActivity />
  </div>
</template>>

<script>
import RandomActivity from "@/components/RandomActivity.vue";

export default {
  components:{
    RandomActivity,
  },
};
</script>

<style>
#app {
  text-align: center;
  margin-top: 50px;
  font-family: Arial, sans-serif;
}
</style>

