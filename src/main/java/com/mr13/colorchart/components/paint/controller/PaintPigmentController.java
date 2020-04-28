package com.mr13.colorchart.components.paint.controller;

import com.mr13.colorchart.components.paint.dto.PaintPigmentForm;
import com.mr13.colorchart.components.paint.service.PaintServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.mr13.colorchart.core.constants.URLConstant.PAINT_BASE_URL;
import static com.mr13.colorchart.core.constants.URLConstant.PIGMENT_BASE_URL;

@RestController
@RequestMapping(PAINT_BASE_URL)
@RequiredArgsConstructor
public class PaintPigmentController {

  private final PaintServiceImpl paintService;

  @PostMapping("/{paintName}" + PIGMENT_BASE_URL)
  @ResponseStatus(HttpStatus.CREATED)
  public void addPigmentToPaint(@Valid @PathVariable String paintName,
      @Valid @RequestBody PaintPigmentForm paintPigmentForm) {
    paintService.addPigmentToPaint(paintName, paintPigmentForm);
  }
}
