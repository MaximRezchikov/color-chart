package com.mr13.colorchart.components.producer.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.paint.domain.Paint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "producer_name", unique = true)
  private String producerName;

  @NotNull
  private String country;

  @JsonIgnore
  @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Paint> paints;
}
