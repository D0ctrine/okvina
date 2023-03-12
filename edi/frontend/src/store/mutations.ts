export function setSearchedMeals(state:any, meals:any) {
    state.searchedMeals = meals || []
  }
  export function setMealsByLetter(state:any, meals:any) {
    state.mealsByLetter = meals || []
  }
  export function setMealsByIngredients(state:any, meals:any) {
    state.mealsByIngredient = meals || []
  }
  export function setIngredient(state:any, ingredient:any) {
    state.ingredient = ingredient
  }