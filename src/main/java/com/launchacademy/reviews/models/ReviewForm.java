package com.launchacademy.reviews.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
public class ReviewForm {

  @NotBlank
  private String name;

  @NotNull
  private Integer rating;

  private String comment;

  @NotNull
  private Long berryId;
}
