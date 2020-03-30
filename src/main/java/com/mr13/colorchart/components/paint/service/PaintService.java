package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;

import java.util.List;

public interface PaintService {

  Paint create(PaintForm paintForm);

  List<Paint> get();

  void delete(Long paintId);
}
