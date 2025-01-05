<template>
  <div class="container">
    <h1 class="title">History</h1>
    <div v-if="loading" class="message">Loading...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else-if="history.length === 0" class="message">No history found.</div>
    <ul v-else class="history-list">
      <li v-for="entry in enrichedHistory" :key="entry.id" class="history-item">
        <strong>Activity:</strong> {{ entry.activityName }}
        <span>(ID: {{ entry.activityId }})</span> -
        <strong>Timestamp:</strong> {{ entry.timestamp }}
      </li>
    </ul>
    <div class="button-group">
      <button @click="goBack" class="btn btn-primary">Back to List</button>
    </div>
  </div>
</template>

<script>
import axios from "../axios";

export default {
  data() {
    return {
      history: [],
      enrichedHistory: [],
      loading: true,
      error: null,
    };
  },
  async created() {
    try {
      const response = await axios.get("/history");
      this.history = response.data;
      const promises = this.history.map(async (entry) => {
        const activityResponse = await axios.get(`/activities/${entry.activityId}`);
        return {
          ...entry,
          activityName: activityResponse.data.name,
        };
      });
      this.enrichedHistory = await Promise.all(promises);
    } catch (error) {
      this.error = "Failed to fetch history. Please try again later.";
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

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #efdcf7;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.title {
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}

.history-list {
  list-style: none;
  padding: 0;
  margin: 20px 0;
}

.history-item {
  padding: 10px 15px;
  margin-bottom: 10px;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 5px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.history-item:hover {
  background-color: #f0f0f0;
}

.message {
  text-align: center;
  font-size: 18px;
  color: #555;
}

.error {
  text-align: center;
  color: red;
  font-size: 18px;
}

.button-group {
  display: flex;
  justify-content: center;
  margin-top: 20px;
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

.btn-primary:hover {
  background-color: #0056b3;
}
</style>
