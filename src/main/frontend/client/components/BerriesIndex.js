import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"

import BerryTile from "./BerryTile"

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

  const berryTiles = berries.map(berry => {
    return <BerryTile key={berry.id} berry={berry} />
  })

  return <div>{berryTiles}</div>
}

export default BerriesIndex
