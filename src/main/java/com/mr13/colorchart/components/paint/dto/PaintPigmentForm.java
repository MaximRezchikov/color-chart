package com.mr13.colorchart.components.paint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class PaintPigmentForm {

  @NotNull
  List<String> pigmentIndexes;
}
