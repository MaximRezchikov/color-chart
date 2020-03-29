package com.mr13.colorchart.components.producer.controller;

import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

  private final ProducerService producerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void saveProducer(@RequestBody ProducerForm producerForm) {
    producerService.save(producerForm);
  }
}
