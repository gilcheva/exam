package com.endava.supermarket.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseParamsDto {
  @NotBlank
  private String superMarketId;

  @NotEmpty
  private List<String> itemIds;

  @NotEmpty
  private String paymentType;
}
