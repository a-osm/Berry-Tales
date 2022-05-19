package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "berries")
@Getter
@Setter
public class Berry {
  @Id
  @SequenceGenerator(name = "berries_generator", sequenceName = "berries_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "berries_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "img_url", nullable = false)
  private String imgUrl;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "berry")
  @JsonIgnoreProperties("berry")
  private List<Review> reviews;
}
