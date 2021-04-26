package com.endava.supermarket.dto;

import com.endava.supermarket.model.enums.Type;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemRequestDto {

  @NotBlank(message = "Please, provide name.")
  private String name;

  @NotNull
  private Double price;

  @Enumerated(EnumType.STRING)
  private Type type;

}
