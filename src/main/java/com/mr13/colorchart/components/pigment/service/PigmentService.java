package com.mr13.colorchart.components.pigment.service;

import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.pigment.dto.PigmentForm;

public interface PigmentService {

  Pigment save(PigmentForm pigmentForm);

  Pigment update(Long pigmentId, PigmentForm pigmentForm);

  Pigment getByName(String pigmentIndex);
}
