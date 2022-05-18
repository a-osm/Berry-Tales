import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"

const BerriesShow = props => {
  const [berry, setBerry] = useState({})
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
      <h1>{berry.name}</h1>
      <p>{berry.description}</p>
      <img src={berry.imgUrl} />
      <Link to={"/berries"}>Back to Home Page</Link>
    </div>
  )
}

export default BerriesShow
