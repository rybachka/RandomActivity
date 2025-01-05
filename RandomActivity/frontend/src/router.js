import { createRouter, createWebHistory } from 'vue-router';
import ActivitiesList from './components/ActivitiesList.vue';
import RandomActivity from './components/RandomActivity.vue';

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
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
