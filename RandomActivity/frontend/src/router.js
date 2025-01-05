import { createRouter, createWebHistory } from 'vue-router';
import ActivitiesList from './components/ActivitiesList.vue';
import RandomActivity from './components/RandomActivity.vue';
import ActivityDetails from './components/ActivityDetails.vue';

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
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
