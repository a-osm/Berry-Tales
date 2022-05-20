import React from "react"

const ReviewTile = ({ review: { name, rating, comment } }) => {
  return (
    <div>
      <h4>Name: {name}</h4>
      <p>Rating: {rating}/5</p>
      <p>Comment: {comment}</p>
    </div>
  )
}

export default ReviewTile
