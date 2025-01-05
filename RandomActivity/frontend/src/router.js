import { createRouter, createWebHistory } from 'vue-router';
import ActivitiesList from './components/ActivitiesList.vue';
import RandomActivity from './components/RandomActivity.vue';
import ActivityDetails from './components/ActivityDetails.vue';
import ActivityHistory from './components/ActivityHistory.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: ActivitiesList,
    },
    {
        path: '/random-activity',
        name: 'RandomActivity',
        component: RandomActivity,
    },
    {
        path: '/activities/:id',
        name: 'ActivityDetails',
        component: ActivityDetails,
    },
    {
        path: '/history',
        name: 'ActivityHistory',
        component: ActivityHistory,

    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
