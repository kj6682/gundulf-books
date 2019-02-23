const defaultState = {
  books: []
}

export default (state=defaultState, action={}) => {
  switch (action.type) {
    case 'FETCH_BOOKS': {
      return {
        ...state,
        books: action.payload
      }
    }
    default:
      return state;
  }
}
