package com.mr13.colorchart.components.pigment.repo;

import com.mr13.colorchart.components.pigment.domain.Pigment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigmentRepository extends JpaRepository<Pigment, Long> {

  Pigment getByPigmentIndex(String pigmentIndex);
}
