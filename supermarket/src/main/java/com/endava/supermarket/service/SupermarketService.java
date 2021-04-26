package com.endava.supermarket.service;

import com.endava.supermarket.dto.AddItmsToSpmktRequestDto;
import com.endava.supermarket.dto.AddItmsToSpmktResponseDto;
import com.endava.supermarket.dto.SupermarketResponseDto;
import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Supermarket;

public interface SupermarketService {

  Item createItem(Item item);

  Supermarket createSupermarket(Supermarket supermarket);

  Item findItemById(String id);

  SupermarketResponseDto findSupermarketById(String id);

  AddItmsToSpmktResponseDto addItemsToSupermarket(AddItmsToSpmktRequestDto dto);

}
