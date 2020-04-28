package com.mr13.colorchart.components.paint.controller;

import com.mr13.colorchart.components.paint.dto.PaintPigmentForm;
import com.mr13.colorchart.components.paint.service.PaintServiceImpl;
import com.mr13.colorchart.components.pigment.dto.PigmentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.mr13.colorchart.core.constants.URLConstant.PAINT_BASE_URL;
import static com.mr13.colorchart.core.constants.URLConstant.PIGMENT_BASE_URL;

@RestController
@RequestMapping(PAINT_BASE_URL)
@RequiredArgsConstructor
public class PaintPigmentController {

  private final PaintServiceImpl paintService;

  @PostMapping("/{paintId}" + PIGMENT_BASE_URL)
  @ResponseStatus(HttpStatus.CREATED)
  public void addPigmentToPaint(@PathVariable Long paintId, @RequestBody PaintPigmentForm paintPigmentForm) {
    paintService.addPigmentToPaint(paintId, paintPigmentForm);
  }
}
