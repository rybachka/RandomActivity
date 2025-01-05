<template>
  <div>
    <h1>History</h1>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else-if="history.length === 0">No history found.</div>
    <ul v-else>
      <li v-for="entry in enrichedHistory" :key="entry.id">
        <strong>Activity:</strong> {{ entry.activityName }}
        <span>(ID: {{ entry.activityId }})</span> -
        <strong>Timestamp:</strong> {{ entry.timestamp}}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from '../axios';

export default {
  data() {
    return {
      history: [],
      enrichedHistory: [],
      loading: true,
      error: null
    };
  },
  async created() {
    try {
      const response = await axios.get('/history');
      this.history = response.data;
      const promises = this.history.map(async (entry) => {
        const activityResponse = await axios.get(`/activities/${entry.activityId}`);
        return {
          ...entry,
          activityName: activityResponse.data.name, // Dodaj nazwę aktywności
        };
      });
      this.enrichedHistory = await Promise.all(promises);
    } catch (error) {
      this.error = 'Failed to fetch history. Please try again later.';
    } finally {
      this.loading = false;
    }
  },

};
</script>