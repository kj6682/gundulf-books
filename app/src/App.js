import React, { Component } from 'react';
import { NavLink, Route } from 'react-router-dom';
import { Container } from 'semantic-ui-react';
import BookListView from './views/book-list-view';
import BookFormView from './views/book-form-view';

class App extends Component {
  render() {
    return (
      <Container>
        <div className="ui two item menu">
          <NavLink className="item" activeClassName="active" exact to="/">
            Book List
          </NavLink>
          <NavLink className="item" activeClassName="active" exact to="/book/new">
            Add Book
          </NavLink>
        </div>
        <Route exact path="/" component={BookListView}/>
        <Route path="/book/new" component={BookFormView}/>
        <Route path="/book/edit/:_id" component={BookFormView}/>
      </Container>
    );
  }
}

export default App;