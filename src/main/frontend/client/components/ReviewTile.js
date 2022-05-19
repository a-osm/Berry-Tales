import React from "react"

const ReviewTile = ({ review: { name, rating, comment } }) => {
  return (
    <li>
      <h4>{name}</h4>
      <p>{rating}/5</p>
      <p>{comment}</p>
    </li>
  )
}

export default ReviewTile
