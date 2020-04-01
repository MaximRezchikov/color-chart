package com.mr13.colorchart.components.producer.controller;

import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.dto.ProducerForm;
import com.mr13.colorchart.components.producer.service.ProducerService;
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
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

  private final ProducerService producerService;

  @GetMapping
  public List<Producer> getAllProducers() {
    return producerService.getAllProducer();
  }

  @GetMapping("/{id}")
  public Producer getOne(@PathVariable("id") Long producerId) {
    return producerService.getOne(producerId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Producer saveProducer(@RequestBody ProducerForm producerForm) {
    return producerService.save(producerForm);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Producer updateProducer(@PathVariable("id") Long producerId, @RequestBody ProducerForm producerForm) {
    return producerService.update(producerId, producerForm);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void removeProducer(@PathVariable("id") Long producerId) {
    producerService.delete(producerId);
  }

}
