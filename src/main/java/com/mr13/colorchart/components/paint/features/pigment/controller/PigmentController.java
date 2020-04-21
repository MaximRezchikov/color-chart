package com.mr13.colorchart.components.paint.features.pigment.controller;

import com.mr13.colorchart.components.paint.features.pigment.domain.Pigment;
import com.mr13.colorchart.components.paint.features.pigment.dto.PigmentForm;
import com.mr13.colorchart.components.paint.features.pigment.service.PigmentService;
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

@RestController
@RequestMapping("/pigment")
@RequiredArgsConstructor
public class PigmentController {

  private final PigmentService pigmentService;

  @GetMapping("/{id}")
  public Pigment getOne(@PathVariable("id") Long pigmentId) {
    return pigmentService.getOne(pigmentId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pigment savePigment(@RequestBody PigmentForm pigmentForm) {
    return pigmentService.save(pigmentForm);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Pigment updatePigment(@PathVariable("id") Long pigmentId, @RequestBody PigmentForm pigmentForm) {
    return pigmentService.update(pigmentId, pigmentForm);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletePigment(@PathVariable("id") Long pigmentId) {
    pigmentService.delete(pigmentId);
  }
}
