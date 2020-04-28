package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;
import com.mr13.colorchart.components.paint.dto.PaintPigmentForm;
import com.mr13.colorchart.components.pigment.dto.PigmentForm;

import java.util.List;

public interface PaintService {

  Paint save(PaintForm paintForm);

  Paint update(Long paintId, PaintForm paintForm);

  List<Paint> getPaintsWithStringPigments();

  void addPigmentToPaint(Long paintId, PaintPigmentForm paintPigmentForm);
}
