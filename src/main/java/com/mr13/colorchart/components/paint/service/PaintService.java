package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;

import java.util.List;

public interface PaintService {

  Paint save(PaintForm paintForm);

  List<Paint> getAllPaints();

  Paint getOne(Long paintId);

  Paint update(Long paintId, PaintForm paintForm);

  void delete(Long paintId);
}
