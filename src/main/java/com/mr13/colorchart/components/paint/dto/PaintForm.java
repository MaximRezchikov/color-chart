package com.mr13.colorchart.components.paint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PaintForm {

  @NotNull
  private String name;

  private String companyColorNumber;

  private Long color;

  @NotNull
  private String producerName;

  private Long paintSerialNumber;

  private Long fileId;

  @NotBlank
  private String lightfastness;

  @NotBlank
  private String opacity;

  @NotBlank
  private String staining;

  @NotBlank
  private String granulation;
}
