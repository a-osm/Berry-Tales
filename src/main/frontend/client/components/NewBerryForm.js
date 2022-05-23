import React, {useState} from "react"
import ErrorList from "./ErrorList"
import _ from "lodash"
import {Redirect} from "react-router-dom"

const NewBerryForm = props => {
  const [formPayload, setFormPayload] = useState({
    name: "",
    imgUrl: "",
    description: ""
  })

  const [errors, setErrors] = useState({})

  const [shouldRedirect, setShouldRedirect] = useState(false)

  const addBerry = async () => {
    try {
      const response = await fetch("/api/v1/berries", {
        method: "POST",
        headers: new Headers({"Content-Type": "application/json"}),
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
    } catch (error) {
      console.error(`Error in fetch ${error.message}`)
    }
  }
  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = ["name", "imgUrl"]
    requiredFields.forEach(field => {
      if (formPayload[field].trim() === "") {
        submitErrors = {...submitErrors, [field]: "Is Blank"}
      }
    })
    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }
  const handleSubmit = event => {
    event.preventDefault()
    if (validForSubmission()) {
      addBerry()
    }
  }
  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  if (shouldRedirect) {
    return <Redirect push to={`/berries`}/>
  }

  return (
      <div>
        <h2>Add New Berry</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="name">Name: </label>
            <input
                type="text"
                name="name"
                id="name"
                value={formPayload.name}
                onChange={handleInputChange}
            />
          </div>
          <div>
            <label htmlFor="imgUrl">Image Link: </label>
            <input
                type="text"
                name="imgUrl"
                id="imgUrl"
                value={formPayload.imgUrl}
                onChange={handleInputChange}
            />
          </div>
          <div>
            <label htmlFor="description">Description: </label>
            <textarea
                type="text"
                name="description"
                id="description"
                value={formPayload.description}
                onChange={handleInputChange}
            />
          </div>
          <div>
            <input type="submit" value="Add New Berry"/>
          </div>
          <div>
            <ErrorList errors={errors}/>
          </div>
        </form>
      </div>
  )
}

export default NewBerryForm
