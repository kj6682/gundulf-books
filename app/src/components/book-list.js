import React from 'react';
import { Card } from 'semantic-ui-react';
import BookCard from './book-card';

export default function BookList({books}){

  const list = () => {
    return books.map(book => {
      return (
        <BookCard key={book.id} book={book}/>
      )
    })
  }

  return (
    <div>
      <ul>
        { list() }
      </ul>
    </div>
  )
}
