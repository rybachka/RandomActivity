<template>
  <div class="container">
    <h1 class="title">Activity Details</h1>
    <div v-if="loading" class="message">Loading...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else>
      <div class="activity-details">
        <h2 class="activity-name">{{ activity.name }}</h2>
        <p><strong>Category:</strong> {{ activity.category }}</p>
        <p><strong>Details:</strong> {{ activity.details }}</p>
      </div>
      <div class="button-group">
        <button
            v-if="!fromFavorites"
            @click="addToFavorites"
            class="btn btn-favorite"
        >
          Add to Favorite
        </button>
        <button @click="goBack" class="btn btn-back">Back to List</button>
      </div>
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
      fromFavorites: false, // Flag to check if navigating from Favorites
    };
  },
  async created() {
    try {
      const { id } = this.$route.params;
      this.fromFavorites = this.$route.params.fromFavorites || false; // Check if coming from Favorites
      const response = await axios.get(`/activities/${id}`);
      this.activity = response.data;
    } catch (error) {
      this.error = "Failed to fetch activity details. Please try again later.";
    } finally {
      this.loading = false;
    }
  },
  methods: {
    async addToFavorites() {
      try {
        const response = await axios.post("/favorites", null, {
          params: { activityId: this.activity.id },
        });

        if (response.data.includes("is already in favorites")) {
          alert(`Activity "${this.activity.name}" is already in your favorites.`);
        } else {
          alert(`Activity "${this.activity.name}" added to favorites!`);
        }
      } catch (error) {
        console.error("Failed to add activity to favorites:", error);
        alert("An error occurred while adding the activity to favorites.");
      }
    },
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

.activity-details {
  margin-bottom: 20px;
}

.activity-name {
  color: #007bff;
  margin-bottom: 10px;
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
  gap: 10px;
}

.btn {
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-favorite {
  background-color: hotpink;
  color: white;
}

.btn-favorite:hover {
  background-color: deeppink;
}

.btn-back {
  background-color: #6c757d;
  color: white;
}

.btn-back:hover {
  background-color: #5a6268;
}
</style>
