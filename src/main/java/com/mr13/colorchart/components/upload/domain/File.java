package com.mr13.colorchart.components.upload.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.paint.domain.Paint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class File {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private byte[] file;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "paint_id", referencedColumnName = "id", insertable = false, updatable = false)
  private Paint paint;
}
