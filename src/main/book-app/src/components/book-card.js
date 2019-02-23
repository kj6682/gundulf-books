import React from 'react';
import { Card, Button } from 'semantic-ui-react'

export default function BookCard({book}) {
  return (
    <Card>
      <Card.Content>
        <Card.Header>
          {book.title}
        </Card.Header>
        <Card.Description>
          <p>{book.category}</p>
          <p>{book.author}</p>
        </Card.Description>
      </Card.Content>
      <Card.Content extra>
        <div className="ui two buttons">
          <Button basic color="green">Edit</Button>
          <Button basic color="red">Delete</Button>
        </div>
      </Card.Content>
    </Card>
  )
}

/*
BookCard.propTypes = {
  book: React.PropTypes.object.isRequired
}
*/
