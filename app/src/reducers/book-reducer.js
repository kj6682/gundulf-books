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
    case "FETCH_BOOKS_FULFILLED": {
          return {
            ...state,
            books: action.payload.data.data || action.payload.data // in case pagination is disabled
          }
        }
    default:
      return state;
  }
}
