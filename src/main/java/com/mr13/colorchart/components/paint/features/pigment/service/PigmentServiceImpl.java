package com.mr13.colorchart.components.paint.features.pigment.service;

import com.mr13.colorchart.components.paint.features.pigment.domain.Pigment;
import com.mr13.colorchart.components.paint.features.pigment.dto.PigmentForm;
import com.mr13.colorchart.components.paint.features.pigment.repo.PigmentRepository;
import com.mr13.colorchart.validation.ColorChartValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PigmentServiceImpl implements PigmentService {

  private final PigmentRepository pigmentRepository;
  private final ColorChartValidation colorChartValidation;

  @Override
  @Transactional
  public Pigment getOne(Long pigmentId) {
    return pigmentRepository.getOne(pigmentId);
  }

  @Override
  public List<Pigment> getAll() {
    return pigmentRepository.findAll();
  }

  @Override
  @Transactional
  public Pigment save(PigmentForm pigmentForm) {

    String pigmentIndex = pigmentForm.getPigmentIndex();
    String pigmentIndexToCheck = pigmentIndex.toUpperCase();
    String pigmentIndexToSave = colorChartValidation.checkPigmentIndex(pigmentIndexToCheck);

    Pigment pigmentToSave = Pigment.builder()
        .pigmentIndex(pigmentIndexToSave)
        .build();

    return pigmentRepository.save(pigmentToSave);
  }

  @Override
  @Transactional
  public Pigment update(Long pigmentId, PigmentForm pigmentForm) {

    String pigmentIndex = pigmentForm.getPigmentIndex();

    Pigment pigmentToChange = getOne(pigmentId);
    pigmentToChange.setPigmentIndex(pigmentIndex);

    return pigmentRepository.save(pigmentToChange);
  }

  @Override
  @Transactional
  public void delete(Long pigmentId) {
    pigmentRepository.deleteById(pigmentId);
  }
}
