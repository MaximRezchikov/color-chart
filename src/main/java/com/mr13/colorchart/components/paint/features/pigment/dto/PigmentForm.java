package com.mr13.colorchart.components.paint.features.pigment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PigmentForm {

  @NotNull
  private String pigmentIndex;
}
