package com.mr13.colorchart.components.paint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaintForm {

  private String colorNumber;

  private String name;

  private Long color;

  private Long serialNumber;

  private Long paintId;
}
