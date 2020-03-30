package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
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

  @Override
  @Transactional
  public Paint create(PaintForm paintForm) {

    String paintName = paintForm.getName();
    String colorNumber = paintForm.getColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getSerialNumber();
    Long producerId = paintForm.getProducerId();

    Paint paint = Paint.builder()
        .name(paintName)
        .colorNumber(colorNumber)
        .color(color)
        .serialNumber(serialNumber)
        .producerId(producerId)
        .build();

    return paintRepository.save(paint);
  }

  @Override
  public List<Paint> get() {
    return paintRepository.findAll();
  }

  @Override
  public void delete(Long paintId) {
    paintRepository.deleteById(paintId);
  }
}
