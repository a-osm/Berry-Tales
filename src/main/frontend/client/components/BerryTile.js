import React from "react"

const BerryTile = props => {
  const { name, imgUrl, description } = props.berry

  return (
    <div>
      <h1>{name}</h1>
      <img src={imgUrl} alt="image" />
      <p>{description}</p>
    </div>
  )
}

export default BerryTile
