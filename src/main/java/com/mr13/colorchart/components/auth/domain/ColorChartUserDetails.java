package com.mr13.colorchart.components.auth.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class ColorChartUserDetails {

  @Id
  private String id;
  private String name;
  private String userpic;
  private String email;
  private String gender;
  private String locale;
  private LocalDateTime lastVisit;
}
