package com.mr13.colorchart.components.pigment.service;

import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.pigment.dto.PigmentForm;
import com.mr13.colorchart.components.pigment.repo.PigmentRepository;
import com.mr13.colorchart.core.service.CommonService;
import com.mr13.colorchart.validation.ColorChartValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PigmentServiceImpl extends CommonService<Pigment> implements PigmentService {

  private final PigmentRepository pigmentRepository;
  private final ColorChartValidation colorChartValidation;

  @Override
  @Transactional
  public Pigment getOne(Long entityId) {
    return super.getOne(entityId);
  }

  @Override
  @Transactional
  public List<Pigment> getAll() {
    return super.getAll();
  }

  @Override
  @Transactional
  public Pigment delete(Long entityId) {
    return super.delete(entityId);
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
    String pigmentIndexToCheck = pigmentIndex.toUpperCase();
    String pigmentIndexToSave = colorChartValidation.checkPigmentIndex(pigmentIndexToCheck);

    Pigment pigmentToChange = getOne(pigmentId);
    pigmentToChange.setPigmentIndex(pigmentIndexToSave);

    return pigmentRepository.save(pigmentToChange);
  }

  @Override
  public JpaRepository<Pigment, Long> getRepository() {
    return pigmentRepository;
  }
}
