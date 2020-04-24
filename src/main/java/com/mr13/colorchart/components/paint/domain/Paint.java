package com.mr13.colorchart.components.paint.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.upload.domain.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
import javax.persistence.OneToOne;
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
public class Paint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

  @Column(name = "company_color_number")
  private String companyColorNumber;

  private Long color;

  private Long producerId;

  private Long fileId;

  private Long pigmentId;

  @Column(name = "serial_number")
  private Long paintSerialNumber;

  private String opacity;

  private String lightfastness;

  private String staining;

  private String granulation;

  @OneToMany(mappedBy = "paint", fetch = FetchType.EAGER)
  private Set<Pigment> pigments;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "producerId", referencedColumnName = "id", insertable = false, updatable = false)
  private Producer producer;

  @OneToOne(mappedBy = "paint", fetch = FetchType.EAGER)
  private File file;
}
