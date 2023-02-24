
export const addCategory = ({ commit }, category) => {
  commit('addCategory', category)
}

export const updateCategory = ({ commit }, category) => {
  commit('updateCategory', category)
}

export const deleteCategory = ({ commit }, category) => {
  commit('deleteCategory', category)
}

export const clickCategory = ({ commit }, category) => {
  commit('clickCategory', category)
}

export const noneClickCategory = ({ commit }) => {
  commit('noneClickCategory')
}
