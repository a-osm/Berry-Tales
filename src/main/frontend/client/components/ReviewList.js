import React from "react"

import ReviewTile from "./ReviewTile"

const ReviewList = props => {
  const reviewTiles = props.reviews?.map(review => {
    return <ReviewTile key={review.id} review={review} />
  })

  return (
    <div>
      <h4>Reviews</h4>
      {reviewTiles}
    </div>
  )
}

export default ReviewList
