<template>
  <div>
    <h1>Favorites</h1>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else-if="favorites.length === 0">No favorites found.</div>
    <ul v-else>
      <li v-for="favorite in enrichedFavorites" :key="favorite.id">
        <strong>Activity:</strong> {{ favorite.activityName }}
        <span>(ID: {{ favorite.activityId }})</span>
      </li>
    </ul>
    <button @click="goBack">Back to List</button>
  </div>
</template>

<script>
import axios from "../axios";

export default {
  data() {
    return {
      favorites: [],
      enrichedFavorites: [],
      loading: true,
      error: null,
    };
  },
  async created() {
    try {
      const response = await axios.get("/favorites");
      this.favorites = response.data;

      // Pobierz szczegóły aktywności dla każdej ulubionej aktywności
      const promises = this.favorites.map(async (favorite) => {
        const activityResponse = await axios.get(`/activities/${favorite.activityId}`);
        return {
          ...favorite,
          activityName: activityResponse.data.name,
        };
      });

      this.enrichedFavorites = await Promise.all(promises);
    } catch (error) {
      this.error = "Failed to fetch favorites. Please try again later.";
    } finally {
      this.loading = false;
    }
  },
  methods: {
    goBack() {
      this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style>
/* Styl opcjonalny */
button {
  margin-top: 20px;
  padding: 10px 15px;
  font-size: 16px;
  cursor: pointer;
  border: none;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
}
button:hover {
  background-color: #0056b3;
}
</style>
