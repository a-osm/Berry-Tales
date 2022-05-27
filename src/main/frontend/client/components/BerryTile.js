import React from "react"
import { Link } from "react-router-dom"

const BerryTile = props => {
  const { name, imageUrl, description, id } = props.berry

  return (
    <div className="berry-tile">
      <Link to={`/berries/${id}`}>
        <h1>{name}</h1>
      </Link>
      <img src={imageUrl} alt="image" />
      <p>{description}</p>
    </div>
  )
}

export default BerryTile
