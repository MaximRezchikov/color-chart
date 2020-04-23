package com.mr13.colorchart.core.controller;

import com.mr13.colorchart.core.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

public abstract class CommonController<T> {

  @Autowired
  private CommonService<T> commonService;

  @GetMapping("/{id}")
  public T getOne(@PathVariable Long id) {
    return commonService.getOne(id);
  }

  @GetMapping
  public List<T> getAll() {

    List<T> entities = commonService.getAll();

    if (CollectionUtils.isEmpty(entities)) {
      return Collections.emptyList();
    }

    return entities;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    commonService.delete(id);
  }
}
