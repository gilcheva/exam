package com.endava.supermarket.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItmsToSpmktRequestDto {

  @NotNull(message = "Please, provide supermarket id.")
  private String supermarketId;

  @NotEmpty
  private List<String> itemIds;
}
