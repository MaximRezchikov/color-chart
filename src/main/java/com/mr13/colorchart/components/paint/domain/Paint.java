package com.mr13.colorchart.components.paint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.paint.features.pigment.domain.Pigment;
import com.mr13.colorchart.components.producer.domain.Producer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paint {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @Column(name = "company_color_number")
  private String companyColorNumber;

  private Long color;

  @Column(name = "producer_id")
  private Long producerId;

  @Column(name = "serial_number")
  private Long paintSerialNumber;

  private String opacity;

  private String lightfastness;

  private String staining;

  private String granulation;

  @JsonIgnore
  @OneToMany(mappedBy = "paint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Pigment> pigments;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "producer_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Producer producer;
}
