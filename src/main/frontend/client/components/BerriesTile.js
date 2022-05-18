import React from "react"
import { Link } from "react-router-dom"

const BerriesTile = props => {
  const { id, name, imgUrl, description } = props.berries

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

export default BerriesTile
