package com.mr13.colorchart.components.paint.features.pigment.service;

import com.mr13.colorchart.components.paint.features.pigment.domain.Pigment;
import com.mr13.colorchart.components.paint.features.pigment.dto.PigmentForm;

public interface PigmentService {

  Pigment getOne(Long pigmentId);

  Pigment save(PigmentForm pigmentForm);

  Pigment update(Long pigmentId, PigmentForm pigmentForm);

  void delete(Long pigmentId);
}
