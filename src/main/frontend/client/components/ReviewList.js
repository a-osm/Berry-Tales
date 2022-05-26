import React from "react"

import ReviewTile from "./ReviewTile"

const ReviewList = props => {
  const reviewTiles = props.reviews?.map(review => {
    return <ReviewTile key={review.id} review={review} />
  })

  return (
    <div>
      <h3 className="review-heading">Reviews</h3>
      {reviewTiles}
    </div>
  )
}

export default ReviewList
