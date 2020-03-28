package com.mr13.colorchart.components.paint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mr13.colorchart.components.producer.domain.Producer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paint {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "color_number")
  private String colorNumber;

  @NotNull
  private String name;

  private Long color;

  @Column(name = "serial_number")
  private Long serialNumber;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "producer_id")
  private Producer producer;
}
