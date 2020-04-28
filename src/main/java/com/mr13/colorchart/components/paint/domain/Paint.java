package com.mr13.colorchart.components.paint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.pigment.domain.Pigment;
import com.mr13.colorchart.components.producer.domain.Producer;
import com.mr13.colorchart.components.picture.domain.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

  @Column(name = "serial_number")
  private Long paintSerialNumber;

  private String opacity;

  private String lightfastness;

  private String staining;

  private String granulation;

  @Transient
  private String pigmentsFromSet;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  @JoinTable(name = "paint_pigments",
      joinColumns = @JoinColumn(name = "paint_id"),
      inverseJoinColumns = @JoinColumn(name = "pigment_id"))
  private Set<Pigment> pigments = new LinkedHashSet<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "producerId", referencedColumnName = "id", insertable = false, updatable = false)
  private Producer producer;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "fileId", referencedColumnName = "id", insertable = false, updatable = false)
  private File file;

  @JsonIgnore
  public boolean addPigment(Pigment pigment) {
    return pigments.add(pigment);
  }

  @JsonIgnore
  public boolean addAllPigments(Collection<Pigment> allPigments) {
    return pigments.addAll(allPigments);
  }
}
