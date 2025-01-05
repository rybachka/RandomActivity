<template>
  <div>
    <h1>List of Activities</h1>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else-if="activities.length === 0">No activities found.</div>
    <ul v-else>
      <li v-for="activity in activities" :key="activity.id">
        <strong>{{ activity.name }}</strong> - {{ activity.category }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from '../axios';

export default {
  data() {
    return {
      activities: [],
      loading: true,
      error: null,
    };
  },
  async created() {
    try {
      const response = await axios.get('/activities');
      this.activities = response.data;
    } catch (error) {
      if (error.response && error.response.data && error.response.data.message) {
        this.error = error.response.data.message;
      } else {
        this.error = 'Failed to fetch activities. Please try again later.';
      }
    } finally {
      this.loading = false;
    }
  },
};
</script>

<style>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  padding: 8px;
  border-bottom: 1px solid #ddd;
}
</style>
