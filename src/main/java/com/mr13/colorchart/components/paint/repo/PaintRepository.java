package com.mr13.colorchart.components.paint.repo;

import com.mr13.colorchart.components.paint.domain.Paint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintRepository extends JpaRepository<Paint, Long> {

}
