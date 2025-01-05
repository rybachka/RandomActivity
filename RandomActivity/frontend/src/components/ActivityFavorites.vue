<template>
  <div class="container">
    <h1 class="title">Favorites</h1>
    <div v-if="loading" class="loading">Loading...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else-if="favorites.length === 0" class="empty-message">No favorites found.</div>
    <div v-else class="card-list">
      <div v-for="favorite in enrichedFavorites" :key="favorite.id" class="card">
        <p><strong>Activity:</strong> {{ favorite.activityName }}</p>
        <p><strong>ID:</strong> {{ favorite.activityId }}</p>
      </div>
    </div>
    <button class="back-button" @click="goBack">Back to List</button>
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
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #efdcf7;
  border-radius: 8px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

.title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
  color: #333;
}

.loading,
.error,
.empty-message {
  text-align: center;
  font-size: 16px;
  color: #555;
}

.card-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.card {
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
}

.back-button {
  display: block;
  margin: 20px auto 0;
  padding: 10px 15px;
  font-size: 16px;
  cursor: pointer;
  border: none;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.back-button:hover {
  background-color: #0056b3;
}
</style>
