import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import DeleteBerryButton from "./DeleteBerryButton.js"
import ReviewList from "./ReviewList"

const BerriesShow = props => {
  const [berry, setBerry] = useState({
    name: "",
    description: "",
    imageUrl: "",
    reviews: []
  })
  const berryId = props.match.params.id

  const fetchBerry = async () => {
    try {
      const response = await fetch(`/api/v1/berries/${berryId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} ($response.statusText)`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setBerry(responseBody.berry)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchBerry()
  }, [])

  return (
    <div>
      <div>
        <span>
          <Link to={"/berries"}>Back to Home Page</Link>
        </span>
        <Link className="right-align" to={`/berries/${berryId}/edit`}>
          Edit this berry!
        </Link>
      </div>
      <h1>{berry.name}</h1>
      <img src={berry.imageUrl} />
      <p>{berry.description}</p>
      <DeleteBerryButton id={berryId} />
      <ReviewList reviews={berry.reviews} />
      <Link to={`/berries/${berryId}/reviews/new`}>
        Add a review to this berry!
      </Link>
    </div>
  )
}

export default BerriesShow
