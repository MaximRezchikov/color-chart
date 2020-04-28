package com.mr13.colorchart.components.paint.controller;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.service.PaintService;
import com.mr13.colorchart.core.controller.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mr13.colorchart.core.constants.URLConstant.PAINT_BASE_URL;

@RestController
@RequestMapping(PAINT_BASE_URL)
@RequiredArgsConstructor
public class PaintController extends CommonController<Paint> {

  private final PaintService paintService;

  @GetMapping("/withpigment")
  public List<Paint> getPaintsWithStringPigments() {
    return paintService.getPaintsWithStringPigments();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Paint savePaint(@RequestBody PaintForm paintForm) {
    return paintService.save(paintForm);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Paint updatePaint(@PathVariable("id") Long paintId, @RequestBody PaintForm paintForm) {
    return paintService.update(paintId, paintForm);
  }
}
