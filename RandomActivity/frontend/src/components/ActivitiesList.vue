<template>
  <div>
    <h1>List of Activities</h1>
    <div>
      <label for="categoryFilter">Filter by category:</label>
      <select id="categoryFilter" v-model="selectedCategory" @change="filterActivities">
        <option value="">All Categories</option>
        <option v-for="category in categories" :key="category" :value="category">
          {{ category }}
        </option>
      </select>
    </div>
    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else-if="activities.length === 0">No activities found.</div>
    <ul v-else>
      <li v-for="activity in filteredActivities" :key="activity.id" @click="viewDetails(activity)">
        <strong>{{ activity.name }}</strong> - {{ activity.category }}
      </li>
    </ul>
    <button @click="goToRandomActivity">Generate random activity</button>
    <button @click="goToHistory">History</button>
  </div>
</template>

<script>
import axios from '../axios';

export default {
  data() {
    return {
      activities: [],
      filteredActivities: [],
      categories: ['Outdoor', 'Creative', 'Indoor', 'Wellness', 'Educational', 'Craft', 'Physical', 'Social'],
      selectedCategory: '',
      loading: true,
      error: null,
    };
  },
  async created() {
    try {
      const response = await axios.get("/activities");
      this.activities = response.data;
      this.filteredActivities = this.activities;
    } catch (error) {
      this.error = "Failed to fetch activities. Please try again later.";
    } finally {
      this.loading = false;
    }
  },
  methods: {
    filterActivities() {
      if (this.selectedCategory) {
        this.filteredActivities = this.activities.filter(
            (activity) => activity.category === this.selectedCategory
        );
      } else {
        this.filteredActivities = this.activities;
      }
    },
    async viewDetails(activity) {
      try {
        await axios.post('/history', null, {
          params: { activityId: activity.id },
        });
        console.log(`Activity with ID ${activity.id} added to history.`);
        this.$router.push({ name: 'ActivityDetails', params: { id: activity.id } });
      } catch (error) {
        console.error("Failed to add to history:", error);
      }
    },
    goToRandomActivity() {
      this.$router.push({ name: 'RandomActivity' });
    },
    goToHistory() {
      this.$router.push({ name: 'ActivityHistory' });
    },
  },
};
</script>
