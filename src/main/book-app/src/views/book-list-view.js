import React, { Component} from 'react';
import { connect } from 'react-redux';
import BookList from '../components/book-list';
import { fetchBooks } from '../actions/book-actions';

class BookListView extends Component {

  componentDidMount() {
    this.props.fetchBooks();
  }

  render() {
    return (
      <div>
        <h1>List of Books</h1>
        <BookList books={this.props.books}/>
      </div>
    )
  }
}

// Make contacts  array available in  props
function mapStateToProps(state) {
  return {
      books : state.bookStore.books
  }
}

export default connect(mapStateToProps, {fetchBooks})(BookListView);