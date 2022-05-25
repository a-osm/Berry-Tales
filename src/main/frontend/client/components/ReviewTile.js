import React from "react"

const ReviewTile = ({ review: { name, rating, comment } }) => {
  return (
    <div className="review-tile">
      <h4 className="review-name">Name: {name}</h4>
      <p className="left-align-indent">Rating: {rating}/5</p>
      <p className="left-align-indent">{comment}</p>
    </div>
  )
}

export default ReviewTile
