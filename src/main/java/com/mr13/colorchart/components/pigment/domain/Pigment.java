package com.mr13.colorchart.components.pigment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mr13.colorchart.components.paint.domain.Paint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = { "id" })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pigment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String name;

  @JsonIgnore
  @ManyToMany(mappedBy = "pigments", fetch = FetchType.LAZY)
  private List<Paint> paints;
}
