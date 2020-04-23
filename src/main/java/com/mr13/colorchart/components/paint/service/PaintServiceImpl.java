package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.error.NotFoundException;
import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.pigment.service.PigmentServiceImpl;
import com.mr13.colorchart.components.paint.repo.PaintRepository;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.service.ProducerServiceImpl;
import com.mr13.colorchart.core.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaintServiceImpl extends CommonService<Paint> implements PaintService {

  private final PaintRepository paintRepository;
  private final ProducerServiceImpl producerService;
  private final PigmentServiceImpl pigmentService;

  @Override
  @Transactional
  public Paint getOne(Long entityId) {
    return super.getOne(entityId);
  }

  @Override
  @Transactional
  public List<Paint> getAll() {
    return super.getAll();
  }

  @Override
  @Transactional
  public Paint delete(Long entityId) {
    return super.delete(entityId);
  }

  @Override
  @Transactional
  public Paint save(PaintForm paintForm) {

    String paintName = paintForm.getName();
    String colorNumber = paintForm.getCompanyColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getPaintSerialNumber();
    String lightfastness = paintForm.getLightfastness();
    String opacity = paintForm.getOpacity();
    String staining = paintForm.getStaining();
    String granulation = paintForm.getGranulation();
    String producerName = paintForm.getProducerName();
    Long producerId = getProducerIdByName(producerName);
    Long fileId = paintForm.getFileId();
    String pigmentIndex = paintForm.getPigmentIndex();
    Long pigmentIdByName = getPigmentIdByName(pigmentIndex);

    Paint paint = Paint.builder()
        .name(paintName)
        .companyColorNumber(colorNumber)
        .color(color)
        .paintSerialNumber(serialNumber)
        .producerId(producerId)
        .lightfastness(lightfastness)
        .opacity(opacity)
        .staining(staining)
        .granulation(granulation)
        .fileId(fileId)
        .pigmentId(pigmentIdByName)
        .build();

    return paintRepository.save(paint);
  }

  @Override
  @Transactional
  public Paint update(Long paintId, PaintForm paintForm) {

    String paintName = paintForm.getName();
    String colorNumber = paintForm.getCompanyColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getPaintSerialNumber();
    String lightfastness = paintForm.getLightfastness();
    String opacity = paintForm.getOpacity();
    String staining = paintForm.getStaining();
    String granulation = paintForm.getGranulation();
    String producerName = paintForm.getProducerName();
    Long producerId = getProducerIdByName(producerName);
    String pigmentIndex = paintForm.getPigmentIndex();
    Long pigmentIdByName = getPigmentIdByName(pigmentIndex);

    Paint paintToChange = getOne(paintId);

    paintToChange.setName(paintName);
    paintToChange.setCompanyColorNumber(colorNumber);
    paintToChange.setColor(color);
    paintToChange.setPaintSerialNumber(serialNumber);
    paintToChange.setLightfastness(lightfastness);
    paintToChange.setOpacity(opacity);
    paintToChange.setStaining(staining);
    paintToChange.setGranulation(granulation);
    paintToChange.setProducerId(producerId);
    paintToChange.setPigmentId(pigmentIdByName);

    return paintRepository.save(paintToChange);
  }

  Long getProducerIdByName(String producerName) {

    List<Producer> allProducers = producerService.getAll();

    return allProducers.stream()
        .filter(producer -> producer.getProducerName().equals(producerName))
        .findFirst()
        .map(Producer::getId)
        .orElseThrow(NotFoundException::new);
  }

  Long getPigmentIdByName(String pigmentName) {

    List<Pigment> allPigments = pigmentService.getAll();

    return allPigments.stream()
        .filter(producer -> producer.getPigmentIndex().equals(pigmentName))
        .findFirst()
        .map(Pigment::getId)
        .orElseThrow(NotFoundException::new);
  }

  @Override
  public JpaRepository<Paint, Long> getRepository() {
    return paintRepository;
  }
}
