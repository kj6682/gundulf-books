import { combineReducers } from 'redux';
import BookReducer from './book-reducer';

const reducers = {
  bookStore: BookReducer
}

const rootReducer = combineReducers(reducers);

export default rootReducer;