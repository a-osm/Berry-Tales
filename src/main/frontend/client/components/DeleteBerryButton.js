import React, { useState } from "react"
import { Redirect } from "react-router-dom"

const DeleteBerryButton = props => {
  const { id } = props
  const [shouldRedirect, setShouldRedirect] = useState(false)
  const deleteBerry = async () => {
    try {
      const response = await fetch(`/api/v1/berries/${id}`, {
        method: "DELETE"
      })
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setShouldRedirect(true)
    } catch (err) {
      console.error(`Error while deleting: ${err.message}`)
    }
  }

  if (shouldRedirect) {
    return <Redirect push to={`/berries`} />
  }

  return (
    <button className="button" onClick={deleteBerry}>
      Delete
    </button>
  )
}

export default DeleteBerryButton
