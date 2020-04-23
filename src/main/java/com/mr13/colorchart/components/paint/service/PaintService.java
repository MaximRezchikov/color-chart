package com.mr13.colorchart.components.paint.service;

import com.mr13.colorchart.components.paint.domain.Paint;
import com.mr13.colorchart.components.paint.dto.PaintForm;

public interface PaintService {

  Paint save(PaintForm paintForm);

  Paint update(Long paintId, PaintForm paintForm);
}
