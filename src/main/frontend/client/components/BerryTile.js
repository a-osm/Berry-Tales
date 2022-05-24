import React from "react"
import { Link } from "react-router-dom"
import DeleteBerryButton from "./DeleteBerryButton.js"

const BerryTile = props => {
  const { name, imgUrl, description, id } = props.berry

  return (
    <div>
      <Link to={`/berries/${id}`}>
        <h1>{name}</h1>
      </Link>
      <img src={imgUrl} alt="image" />
      <p>{description}</p>
    </div>
  )
}

export default BerryTile
