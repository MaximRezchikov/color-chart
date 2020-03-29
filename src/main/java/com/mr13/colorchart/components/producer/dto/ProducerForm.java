package com.mr13.colorchart.components.producer.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ProducerForm {

  @NotBlank
  @ApiModelProperty(required = true)
  private String producerName;

  @NotBlank
  @ApiModelProperty
  private String country;
}
