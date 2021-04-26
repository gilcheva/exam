package com.endava.supermarket.model;

import com.endava.supermarket.model.enums.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name="items")
public class Item {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name="item_id")
  private String itemId;

  @NotBlank(message = "Please, provide name.")
  @Column(length = 64)
  private String name;

  @NotNull
  @Column
  private Double price;

  @Column
  @Enumerated(EnumType.STRING)
  private Type type;

  @ManyToOne
  @JoinColumn(name = "supermarket_id")
  private Supermarket supermarket;
}
