package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.repo.PaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaintServiceImpl implements PaintService {

  private final PaintRepository paintRepository;

  @Override
  public Paint create(PaintForm paintForm) {

    String paintName = paintForm.getName();
    String colorNumber = paintForm.getColorNumber();
    Long color = paintForm.getColor();
    Long serialNumber = paintForm.getSerialNumber();

    Paint paint = Paint.builder()
        .name(paintName)
        .colorNumber(colorNumber)
        .color(color)
        .serialNumber(serialNumber)
        .build();

    return paintRepository.save(paint);
  }
}
