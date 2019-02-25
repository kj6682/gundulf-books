import { books } from '../book-data';
import { client } from './';

const url = '/api/books/v1.0/';

export function fetchBooks(){
  return dispatch => {
    dispatch({
      type: 'FETCH_BOOKS',
      payload: client.get(url)
    })
  }
}

