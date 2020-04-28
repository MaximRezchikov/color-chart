package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.error.NotFoundException;
import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.dto.PaintPigmentForm;
import com.mr13.colorchart.components.paint.repo.PaintRepository;
import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.pigment.service.PigmentServiceImpl;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.producer.service.ProducerServiceImpl;
import com.mr13.colorchart.core.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

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
  public List<Paint> getPaintsWithStringPigments() {

    List<Paint> allPaints = getAll();
    List<String> pigmentIndexes = new ArrayList<>();

    IntStream.range(0, allPaints.size()).forEach(i -> {

      Paint paint = allPaints.get(i);
      Set<Pigment> pigments = paint.getPigments();

      List<Pigment> pigmentList = new ArrayList<>(pigments);
      pigmentList.stream()
          .map(Pigment::getName)
          .forEach(pigmentIndexes::add);

      String join = String.join(",", pigmentIndexes);
      paint.setPigmentsFromSet(join);
      allPaints.set(i, paint);
      pigmentIndexes.clear();
    });

    return allPaints;
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
    Producer producer = producerService.getByName(producerName);
    Long producerId = producer.getId();
    Long fileId = paintForm.getFileId();

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
    Producer producer = producerService.getByName(producerName);
    Long producerId = producer.getId();

    if (exists(paintId)) {
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

      return paintRepository.save(paintToChange);
    }
    else {
      throw new NotFoundException();
    }
  }

  @Override
  @Transactional
  public void addPigmentToPaint(Long paintId, PaintPigmentForm paintPigmentForm) {

    Paint paint = getOne(paintId);
    List<String> names = paintPigmentForm.getNames();

    names.stream()
        .map(pigmentService::getByName)
        .forEach(paint::addPigment);

    paintRepository.save(paint);
  }

  @Override
  public JpaRepository<Paint, Long> getRepository() {
    return paintRepository;
  }
}
