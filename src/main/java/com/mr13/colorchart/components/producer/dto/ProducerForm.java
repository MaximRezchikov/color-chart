package com.mr13.colorchart.components.producer.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProducerForm {

  @NotNull
  @ApiModelProperty(required = true)
  private String producerName;

  @NotNull
  @ApiModelProperty
  private String country;
}
