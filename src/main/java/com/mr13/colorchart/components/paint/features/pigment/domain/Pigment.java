package com.mr13.colorchart.components.paint.features.pigment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mr13.colorchart.components.paint.domain.Paint;
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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pigment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String pigmentIndex;

  @Column(name = "paint_id")
  private Long paintId;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "paint_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Paint paint;
}
