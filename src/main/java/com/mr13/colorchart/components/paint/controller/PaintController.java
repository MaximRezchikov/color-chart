package com.mr13.colorchart.components.paint.controller;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.service.PaintService;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paint")
@RequiredArgsConstructor
public class PaintController {

  private final PaintService paintService;

  @GetMapping
  public List<Paint> getPaint() {
    return paintService.get();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Paint createPaint(@RequestBody PaintForm paintForm) {
    return paintService.create(paintForm);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletePaint(@PathVariable("id") Long paintId) {
    paintService.delete(paintId);
  }
}
