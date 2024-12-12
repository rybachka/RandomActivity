<template>
  <div>
    <h2>Losuj Aktywnosc</h2>>
    <button @click="fetchActivity">Losuj aktywnosc</button>>
    <p v-if="activity">Twoja aktywnosc: {{ activity.name}}</p>
    <p v-else>Brak aktywnosci</p>>
  </div>
</template>>

<script>
export default {
  data() {
    return{
      activity: null,
    };
  },
  methods: {
    fetchActivity() {
      setTimeout(() => {
        const mockResponse = {
          name: "Idz na spacer",
          category: 'Relaks',
        };
        this.activity = mockResponse;
      }, 500)
    },
  },
};
</script>

<style scoped>
button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>
