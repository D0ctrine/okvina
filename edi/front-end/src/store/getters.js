export const user = state => state.user

export const hasBoards = state => {
  return state.boards.length > 0
}

export const clickedCategory = state => {
  return state.selectedCategory
}

export const categoryClickFlag = state => {
  return state.categorySelectedFlag
}

export const teamBoards = state => {
  const teams = []

  state.teams.forEach(team => {
    teams.push({
      id: team.id,
      name: team.name,
      boards: state.boards.filter(board => board.teamId === team.id)
    })
  })

  return teams
}
