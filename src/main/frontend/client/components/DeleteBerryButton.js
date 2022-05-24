import React, { useState } from "react"

const DeleteBerryButton = props => {
  const { id } = props
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
      window.location.reload(true)
    } catch (err) {
      console.error(`Error while deleting: ${err.message}`)
    }
  }

  return (
    <button className="button" onClick={deleteBerry}>
      Delete
    </button>
  )
}

export default DeleteBerryButton
