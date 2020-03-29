package com.mr13.colorchart.components.producer.controller;

import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

  private final ProducerService producerService;

  @GetMapping
  public List<Producer> getAllProducers() {
    return producerService.getAllProducer();
  }

  @GetMapping("{id}")
  public Producer getOne(@PathVariable Long id) {
    return producerService.getOne(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void saveProducer(@RequestBody ProducerForm producerForm) {
    producerService.save(producerForm);
  }
}
