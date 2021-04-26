package com.endava.supermarket.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItmsToSpmktResponseDto {

  private String supermarketId;

  private List<String> itemsNames;
}
