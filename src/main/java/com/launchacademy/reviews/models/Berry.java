package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;


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

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "berry",cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties("berry")
  private List<Review> reviews;
}
