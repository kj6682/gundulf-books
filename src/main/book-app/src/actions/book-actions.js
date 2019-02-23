import { books } from '../book-data';

export function fetchBooks(){
  return dispatch => {
    dispatch({
      type: 'FETCH_BOOKS',
      payload: books
    })
  }
}