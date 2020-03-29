package com.mr13.colorchart.components.paint.dto;

import com.mr13.colorchart.components.producer.domain.Producer;
import lombok.Builder;
import lombok.Data;

@Data
public class PaintForm {

  private String colorNumber;

  private String name;

  private Long color;

  private Long serialNumber;

  private Long producerId;
}
