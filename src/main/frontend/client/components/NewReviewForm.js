import React, { useState } from "react"
import { Redirect } from "react-router"
import { Link } from "react-router-dom"
import _ from "lodash"

import ErrorList from "./ErrorList"

const NewReviewForm = props => {
  const [formPayload, setFormPayload] = useState({
    name: "",
    rating: "",
    comment: ""
  })
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const addReview = async formPayload => {
    const berryId = props.match.params.id
    formPayload.berryId = berryId
    try {
      const response = await fetch(`/api/v1/berries/${berryId}/reviews`, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json()
          return setErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw error
        }
      }

      const body = await response.json()
      setShouldRedirect(true)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const handleSubmit = event => {
    event.preventDefault()
    addReview(formPayload)
  }

  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  if (shouldRedirect) {
    return <Redirect push to={`/berries/${props.match.params.id}`} />
  }

  return (
    <div>
      <h1>Add a review to this berry!</h1>
      <Link to={"/berries"}>Back to berries</Link>
      <form className="callout" onSubmit={handleSubmit}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">Name: </label>
          <input
            name="name"
            id="name"
            type="text"
            value={formPayload.name}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="rating">Rating: </label>
          <input
            name="rating"
            id="rating"
            type="number"
            min="1"
            max="5"
            value={formPayload.rating}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="comment">Comment: </label>
          <input
            name="comment"
            id="comment"
            type="text"
            value={formPayload.comment}
            onChange={handleInputChange}
          />
        </div>

        <input className="button" type="submit" value="Submit" />
      </form>
    </div>
  )
}

export default NewReviewForm
