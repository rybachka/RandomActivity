<template>
  <div class="container mt-5 text-center">
    <h1 class="mb-4">Random Activity</h1>
    <div v-if="loading">
      <div class="spinner-border text-primary" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>
    <div v-else-if="error" class="text-danger">{{ error }}</div>
    <div v-else>
      <div class="card mb-4">
        <div class="card-body">
          <h3 class="card-title">{{ activity.name }}</h3>
          <h4 class="card-subtitle mb-2 text-muted">{{ activity.category }}</h4>
          <p class="card-text">{{ activity.details }}</p>
        </div>
      </div>
      <button class="btn btn-primary me-2" @click="fetchRandomActivity">Generate random activity</button>
      <button class="btn btn-secondary" @click="goToAllActivities">Return to all activities</button>
    </div>
  </div>
</template>

<script>
import axios from "../axios";

export default {
  data() {
    return {
      activity: null,
      loading: true,
      error: null,
    };
  },
  async created() {
    await this.fetchRandomActivity();
  },
  methods: {
    async fetchRandomActivity() {
      this.loading = true;
      this.error = null;
      try {
        const response = await axios.get("/activities/random");
        this.activity = response.data;
      } catch (error) {
        this.error = "Failed to fetch random activity. Please try again later.";
      } finally {
        this.loading = false;
      }
    },
    goToAllActivities() {
      this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #efdcf7;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}



.btn {
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
.btn-primary {
  background-color: #007bff;
  color: white;
}

</style>