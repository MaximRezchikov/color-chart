package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.repo.PaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaintServiceImpl implements PaintService {

  private final PaintRepository paintRepository;

  @Override
  @Transactional
  public Paint save(PaintForm paintForm) {

    String paintName = paintForm.getName();
    String colorNumber = paintForm.getColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getSerialNumber();
    String lightfastness = paintForm.getLightfastness();
    String opacity = paintForm.getOpacity();
    String staining = paintForm.getStaining();
    String granulation = paintForm.getGranulation();
    Long producerId = paintForm.getProducerId();

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
    String colorNumber = paintForm.getColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getSerialNumber();
    String lightfastness = paintForm.getLightfastness();
    String opacity = paintForm.getOpacity();
    String staining = paintForm.getStaining();
    String granulation = paintForm.getGranulation();
    Long producerId = paintForm.getProducerId();

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

  @Override
  @Transactional
  public void delete(Long paintId) {
    paintRepository.deleteById(paintId);
  }
}
