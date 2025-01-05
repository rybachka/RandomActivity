<template>
  <div>
    <h1>Random Activity</h1>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else>
      <strong>{{ activity.name }}</strong> - {{ activity.category }}
      <p>{{ activity.details }}</p>
    </div>
    <div>
      <button @click="fetchRandomActivity">Generate random activity</button>
      <button @click="goToAllActivities">Return to all activities</button>
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
    await this.fetchRandomActivity();
  },
  methods: {
    async fetchRandomActivity() {
      this.loading = true;
      this.error = null;
      try {
        const response = await axios.get('/activities/random');
        this.activity = response.data;
      } catch (error) {
        this.error = 'Failed to fetch random activity. Please try again later.';
      } finally {
        this.loading = false;
      }
    },
    goToAllActivities() {
      this.$router.push('/');
    },
  },
};
</script>

<style>
button {
  margin: 10px;
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