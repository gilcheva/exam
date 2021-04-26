package com.endava.supermarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name="supermarkets",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Supermarket {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name="supermarket_id")
  private String supermarketId;

  @NotBlank(message = "Please, provide name.")
  @Column(length = 64, unique = true)
  private String name;

  @NotBlank(message = "Please, provide address.")
  @Column(length = 128)
  private String address;

  @Column(name="phone_number")
  private String phoneNumber;

  @Column(name="work_hours")
  private String workHours;

}
