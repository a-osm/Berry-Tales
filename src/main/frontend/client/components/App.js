import React, { useEffect } from "react"
import { hot } from "react-hot-loader/root"
import "foundation-sites"
import $ from "jquery"
import { Route, BrowserRouter, Switch, Redirect } from "react-router-dom"

import BerriesIndex from "./BerriesIndex"
import BerriesShow from "./BerriesShow"
import NewBerryForm from "./NewBerryForm.js"

const App = props => {
  useEffect(() => {
    $(document).foundation()
  }, [])

  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Redirect to="/berries" />
        </Route>
        <Route exact path="/berries" component={BerriesIndex} />
        <Route exact path="/berries/new" component={NewBerryForm} />
        <Route exact path="/berries/:id" component={BerriesShow} />
      </Switch>
    </BrowserRouter>
  )
}

export default hot(App)
