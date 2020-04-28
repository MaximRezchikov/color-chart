package com.mr13.colorchart.components.pigment.controller;

import com.mr13.colorchart.components.pigment.converter.PigmentToPigmentIndexConverter;
import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.pigment.dto.PigmentForm;
import com.mr13.colorchart.components.pigment.service.PigmentService;
import com.mr13.colorchart.components.pigment.service.PigmentServiceImpl;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pigment")
@RequiredArgsConstructor
public class PigmentController extends CommonController<Pigment> {

  private final PigmentService pigmentService;
  private final PigmentServiceImpl pigmentServiceImpl;
  private final PigmentToPigmentIndexConverter pigmentToPigmentIndexConverter;

  @GetMapping("/pgindexes")
  public List<String> getPigmentIndexes() {

    List<Pigment> allPigments = pigmentServiceImpl.getAll();

    return pigmentToPigmentIndexConverter.convert(allPigments);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pigment savePigment(@Valid @RequestBody PigmentForm pigmentForm) {
    return pigmentService.save(pigmentForm);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Pigment updatePigment(@PathVariable("id") Long pigmentId, @Valid @RequestBody PigmentForm pigmentForm) {
    return pigmentService.update(pigmentId, pigmentForm);
  }
}
