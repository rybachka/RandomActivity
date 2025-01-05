<template>
  <div>
    <h1>Activity Details</h1>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else>
      <h2>{{ activity.name }}</h2>
      <p><strong>Category:</strong> {{ activity.category }}</p>
      <p><strong>Details:</strong> {{ activity.details }}</p>
      <button @click="addToFavorites">Add to Favorite</button>
      <button @click="goBack">Back to List</button>
    </div>
  </div>
</template>

<script>
import axios from '../axios';

export default {
  data() {
    return {
      activity: null,
      loading: true,
      error: null,
    };
  },
  async created() {
    try {
      const { id } = this.$route.params;
      const response = await axios.get(`/activities/${id}`);
      this.activity = response.data;
    } catch (error) {
      this.error = 'Failed to fetch activity details. Please try again later.';
    } finally {
      this.loading = false;
    }
  },
  methods: {
    async addToFavorites() {
      try {
        await axios.post("/favorites", null, {
          params: { activityId: this.activity.id },
        });
        alert(`Activity "${this.activity.name}" added to favorites!`);
      } catch (error) {
        console.error("Failed to add activity to favorites:", error);
        alert("An error occurred while adding the activity to favorites.");
      }
    },
    goBack() {
      this.$router.push({ name: 'Home' });
    },
  },
};
</script>
