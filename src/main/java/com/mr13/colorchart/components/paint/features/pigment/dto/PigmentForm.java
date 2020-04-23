package com.mr13.colorchart.components.paint.features.pigment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PigmentForm {

  @NotNull
  private String pigmentIndex;
}
