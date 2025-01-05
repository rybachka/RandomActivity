<template>
  <div class="container">
    <h1 class="title">List of Activities</h1>
    <div class="filter">
      <label for="categoryFilter">Filter by category:</label>
      <select id="categoryFilter" v-model="selectedCategory" @change="filterActivities">
        <option value="">All Categories</option>
        <option v-for="category in categories" :key="category" :value="category">
          {{ category }}
        </option>
      </select>
    </div>
    <div v-if="loading" class="message">Loading...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else-if="activities.length === 0" class="message">No activities found.</div>
    <ul class="activity-list" v-else>
      <li v-for="activity in filteredActivities" :key="activity.id" class="activity-item" @click="viewDetails(activity)">
        <strong>{{ activity.name }}</strong> - {{ activity.category }}
      </li>
    </ul>
    <div class="button-group">
      <button @click="goToRandomActivity" class="btn btn-primary">Generate random activity</button>
      <button @click="goToHistory" class="btn btn-secondary">History</button>
      <button @click="goToFavorites" class="btn btn-secondary">Favorites</button>
    </div>
  </div>
</template>

<script>
import axios from "../axios";

export default {
  data() {
    return {
      activities: [],
      filteredActivities: [],
      categories: ["Outdoor", "Creative", "Indoor", "Wellness", "Educational", "Craft", "Physical", "Social"],
      selectedCategory: "",
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
        this.filteredActivities = this.activities.filter((activity) => activity.category === this.selectedCategory);
      } else {
        this.filteredActivities = this.activities;
      }
    },
    async viewDetails(activity) {
      try {
        await axios.post("/history", null, { params: { activityId: activity.id } });
        this.$router.push({ name: "ActivityDetails", params: { id: activity.id } });
      } catch (error) {
        console.error("Failed to add to history:", error);
      }
    },
    goToRandomActivity() {
      this.$router.push({ name: "RandomActivity" });
    },
    goToHistory() {
      this.$router.push({ name: "ActivityHistory" });
    },
    goToFavorites() {
      this.$router.push({ name: "ActivityFavorites" });
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
}

.title {
  text-align: center;
  margin-bottom: 20px;
}

.filter {
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.activity-list {
  list-style: none;
  padding: 0;
}

.activity-item {
  padding: 10px;
  margin: 5px 0;
  background-color: #f8f9fa;
  border: 1px solid #ddd;
  cursor: pointer;
}

.activity-item:hover {
  background-color: #e9ecef;
}

.button-group {
  display: flex;
  gap: 10px;
  justify-content: center;
}

.btn {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-primary {
  background-color: #007bff;
  color: white;
}

.btn-secondary {
  background-color: #6c757d;
  color: white;
}

.btn:hover {
  opacity: 0.9;
}

.message {
  text-align: center;
  font-size: 18px;
  color: #555;
}

.error {
  color: red;
  text-align: center;
}
</style>
