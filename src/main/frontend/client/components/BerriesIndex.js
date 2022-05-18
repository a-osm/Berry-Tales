import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"

import BerriesTile from "./BerriesTile"

const BerriesIndex = props => {
  const [berries, setBerries] = useState([])

  const fetchBerries = async () => {
    try {
      const response = await fetch("/api/v1/berries")
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setBerries(responseBody.berries)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchBerries()
  }, [])

  const berryTiles = berries.map(berries => {
    return <BerriesTile key={berries.id} berries={berries} />
  })

  return (
    <div>
      <Link to={"/berries/new"}>Add a new berry</Link>
      {berryTiles}
    </div>
  )
}

export default BerriesIndex
