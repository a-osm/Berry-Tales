import React, { useEffect } from "react"
import { hot } from "react-hot-loader/root"
// import "foundation-sites"
import "../assets/scss/main.scss"
import $ from "jquery"
import { Route, BrowserRouter, Switch, Redirect } from "react-router-dom"

import BerriesIndex from "./BerriesIndex"
import BerriesShow from "./BerriesShow"
import NewReviewForm from "./NewReviewForm"
import NewBerryForm from "./NewBerryForm.js"
import BerryEdit from "./BerryEdit.js"

const App = props => {
  useEffect(() => {
    // $(document).foundation()
  }, [])

  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Redirect to="/berries" />
        </Route>
        <Route exact path="/berries" component={BerriesIndex} />
        <Route
          exact
          path="/berries/:id/reviews/new"
          component={NewReviewForm}
        />
        <Route exact path="/berries/new" component={NewBerryForm} />
        <Route exact path="/berries/:id" component={BerriesShow} />
        <Route exact path="/berries/:id/edit" component={BerryEdit} />
      </Switch>
    </BrowserRouter>
  )
}

export default hot(App)
