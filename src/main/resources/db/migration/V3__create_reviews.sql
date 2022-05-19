CREATE TABLE reviews (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  rating INTEGER NOT NULL,
  comment text,
  berry_id BIGINT NOT NULL REFERENCES berries(id)
);