package com.mr13.colorchart.components.producer.repo;

import com.mr13.colorchart.components.producer.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

}
