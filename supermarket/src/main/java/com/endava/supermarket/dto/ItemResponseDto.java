package com.endava.supermarket.dto;

import com.endava.supermarket.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDto {

  private String id;

  private String name;

  private Double price;

  private Type type;

}
