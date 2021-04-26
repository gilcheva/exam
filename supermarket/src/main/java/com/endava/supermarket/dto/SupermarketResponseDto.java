package com.endava.supermarket.dto;

import com.endava.supermarket.model.enums.Type;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupermarketResponseDto {

  private String name;

  private String address;

  private String phoneNumber;

  private String workHours;

  private List<ItemResponseDto> items;
}
