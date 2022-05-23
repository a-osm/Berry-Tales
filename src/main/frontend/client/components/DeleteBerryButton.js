import React from "react"

const DeleteBerryButton = props => {
  const deleteBerry = () => {}

  const handleSubmit = event => {
    event.preventDefault()
    deleteBerry()
  }
  return (
    <>
      <form onSubmit={handleSubmit}>
        <div>
          <input type="submit" value="Delete" />
        </div>
      </form>
    </>
  )
}

export default DeleteBerryButton
