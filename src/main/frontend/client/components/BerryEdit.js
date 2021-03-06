import _ from "lodash"
import React, { useState } from "react"
import { Redirect } from "react-router"
import ErrorList from "./ErrorList"

const BerryEdit = props => {
  const [formPayload, setFormPayload] = useState({
    name: "",
    imageUrl: "",
    description: ""
  })
  const [errors, setErrors] = useState({})
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const editBerry = async () => {
    const berryId = props.match.params.id
    try {
      const response = await fetch(`/api/v1/berries/${berryId}/edit`, {
        method: "PUT",
        headers: new Headers({ "Content-Type": "application/json" }),
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
      setShouldRedirect(true)

      const body = await response.json()
    } catch (error) {
      console.error(`Error in fetch ${error.message}`)
    }
  }

  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = ["name", "imageUrl"]
    requiredFields.forEach(field => {
      if (formPayload[field].trim() === "") {
        submitErrors = { ...submitErrors, [field]: "Is Blank" }
      }
    })
    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleSubmit = event => {
    event.preventDefault()
    if (validForSubmission()) {
      editBerry()
    }
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
      <h2 className="edit-title">Edit Berry</h2>
      <form onSubmit={handleSubmit}>
        <div className="edit-input">
          <label htmlFor="name">Name: </label>
          <input
            type="text"
            name="name"
            id="name"
            value={formPayload.name}
            onChange={handleInputChange}
          />
        </div>
        <div className="edit-input">
          <label htmlFor="imageUrl">Image Url: </label>
          <input
            type="text"
            name="imageUrl"
            id="imageUrl"
            value={formPayload.imageUrl}
            onChange={handleInputChange}
          />
        </div>
        <div className="edit-input">
          <label htmlFor="description">Description: </label>
          <textarea
            type="text"
            name="description"
            id="description"
            value={formPayload.description}
            onChange={handleInputChange}
          />
        </div>
        <div className="edit-input">
          <input type="submit" value="Submit Edits" />
        </div>
        <div>
          <ErrorList errors={errors} />
        </div>
      </form>
    </div>
  )
}

export default BerryEdit
