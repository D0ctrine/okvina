import { createRouter, createWebHistory } from "vue-router";
import DefaultLayout from '../components/DefaultLayout.vue';
import GuestLayout from '../components/GuestLayout.vue';
import Home from '../views/Home.vue'
import MealsByIngredient from '../views/MealsByIngredient.vue'
import MealsByLetter from '../views/MealsByLetter.vue'
import MealsByName from '../views/MealsByName.vue'
import MealDetails from '../views/MealDetails.vue'
import Ingredients from '../views/Ingredients.vue'

const routes = [
  {
    path: '/',
    component: DefaultLayout,
    children: [
      {
        path: "/",
        name: "home",
        component: Home,
      },
      {
        path: "/by-name/:name?",
        name: "dev",
        component: MealsByName,
      },
      {
        path: "/by-letter/:letter?",
        name: "biz",
        component: MealsByLetter,
      },
      {
        path: "/ingredients",
        name: "fin",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "IT",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "product",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "myedu",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "design",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "marketing",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "health",
        component: Ingredients,
      },
      {
        path: "/ingredients",
        name: "music",
        component: Ingredients,
      },
      {
        path: "/by-ingredient/:ingredient",
        name: "byIngredient",
        component: MealsByIngredient,
      },
      {
        path: '/meal/:id',
        name: 'mealDetails',
        component: MealDetails
      }
    ]
  },
  {
    path: '/guest',
    component: GuestLayout
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
