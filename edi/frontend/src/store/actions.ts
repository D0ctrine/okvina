import axiosClient from '../axiosClient';

export function searchMeals({ commit }:any, keyword:string) {
  axiosClient.get(`search.php?s=${keyword}`)
    .then(({ data }) => {
      commit('setSearchedMeals', data.meals)
    })
}

export function searchMealsByLetter({ commit }:any, letter:string) {
  axiosClient.get(`search.php?f=${letter}`)
    .then(({ data }) => {
      commit('setMealsByLetter', data.meals)
    })
}

export function searchMealsByIngredient({ commit }:any, ing:string) {
  axiosClient.get(`filter.php?i=${ing}`)
    .then(({ data }) => {
      commit('setMealsByIngredients', data.meals)
    })
}