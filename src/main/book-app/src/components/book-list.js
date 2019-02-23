import React from 'react';

export default function BookList({books}){

  const list = () => {
    return books.map(book => {
      return (
        <li key={book._id}>{book.title} {book.author}</li>
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
