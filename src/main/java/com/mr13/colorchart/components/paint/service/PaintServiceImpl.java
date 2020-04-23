package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.error.NotFoundException;
import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.features.pigment.domain.Pigment;
import com.mr13.colorchart.components.paint.features.pigment.service.PigmentService;
import com.mr13.colorchart.components.paint.repo.PaintRepository;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaintServiceImpl implements PaintService {

  private final PaintRepository paintRepository;
  private final ProducerService producerService;
  private final PigmentService pigmentService;

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
  public List<Paint> getAllPaints() {
    return paintRepository.findAll();
  }

  @Override
  @Transactional
  public Paint getOne(Long paintId) {
    return paintRepository.getOne(paintId);
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

  @Override
  @Transactional
  public void delete(Long paintId) {
    paintRepository.deleteById(paintId);
  }

  Long getProducerIdByName(String producerName) {

    List<Producer> allProducers = producerService.getAllProducer();

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
}
