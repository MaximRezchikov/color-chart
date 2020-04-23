package com.mr13.colorchart.core.service;


import com.mr13.colorchart.components.error.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class CommonService<T> {

  @Transactional
  public T getOne(Long entityId) {

    JpaRepository<T, Long> repository = getRepository();
    T entity = repository.getOne(entityId);

    if (entity == null) {
      throw new NotFoundException();
    }

    return entity;
  }

  @Transactional
  public List<T> getAll() {

    JpaRepository<T, Long> repository = getRepository();

    return repository.findAll();
  }

  @Transactional
  public T delete(Long entityId) {

    T deletedEntity = getOne(entityId);

    JpaRepository<T, Long> repository = getRepository();
    repository.deleteById(entityId);

    return deletedEntity;
  }

  public boolean exists(Long entityId) {

    JpaRepository<T, Long> repository = getRepository();

    return repository.existsById(entityId);
  }

  public abstract JpaRepository<T, Long> getRepository();
}
