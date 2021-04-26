package com.endava.supermarket.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSupermarketRequestDto {

  @NotBlank(message = "Please, provide supermarket name.")
  private String name;

  @NotBlank
  private String address;

  private String phoneNumber;

  private String workHours;
}
