package com.mr13.colorchart.components.paint.controller;

import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.service.PaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paint")
@RequiredArgsConstructor
public class PaintController {

  private final PaintService paintService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createPaint(@RequestBody PaintForm paintForm) {
    paintService.create(paintForm);
  }

}
