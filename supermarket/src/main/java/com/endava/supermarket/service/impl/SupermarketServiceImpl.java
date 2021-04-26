package com.endava.supermarket.service.impl;

import com.endava.supermarket.dto.AddItmsToSpmktRequestDto;
import com.endava.supermarket.dto.AddItmsToSpmktResponseDto;
import com.endava.supermarket.dto.ItemResponseDto;
import com.endava.supermarket.dto.SupermarketResponseDto;
import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Supermarket;
import com.endava.supermarket.repository.ItemRepository;
import com.endava.supermarket.repository.SupermarketRepository;
import com.endava.supermarket.service.SupermarketService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupermarketServiceImpl implements SupermarketService {

  private final ItemRepository itemRepository;
  private final SupermarketRepository supermarketRepository;
  private final ModelMapper modelMapper;

  public Item createItem(Item item) {
    return itemRepository.save(item);
  }

  public Item findItemById(String id) {
    return itemRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Not existing ID."));
  }

  public Supermarket createSupermarket(Supermarket supermarket) {
    return supermarketRepository.save(supermarket);
  }

  public SupermarketResponseDto findSupermarketById(String id) {
    Supermarket supermarket = supermarketRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Not existing supermarket ID."));
    List<Item> items = itemRepository.findAllBySupermarket(supermarket);
    List<ItemResponseDto> itemResponseDtos = items.stream()
        .map(item -> modelMapper.map(item, ItemResponseDto.class))
        .collect(Collectors.toList());
    SupermarketResponseDto supermarketResponseDto = modelMapper.map(supermarket,SupermarketResponseDto.class);
    supermarketResponseDto.setItems(itemResponseDtos);
    return supermarketResponseDto;
  }

  public AddItmsToSpmktResponseDto addItemsToSupermarket(AddItmsToSpmktRequestDto dto) {
    Supermarket supermarket = supermarketRepository.findById(dto.getSupermarketId())
        .orElseThrow(() -> new IllegalArgumentException("Non-existing supermarket."));
    List<String> items = dto.getItemIds().stream()
        .map(id -> itemRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Non-existing item.")))
        .map(Item::getName)
        .collect(Collectors.toList());
    dto.getItemIds().stream().map(id -> itemRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Non-existing item.")))
        .forEach(item -> {
          item.setSupermarket(supermarket);
          itemRepository.save(item);
        });
    AddItmsToSpmktResponseDto responseDto = new AddItmsToSpmktResponseDto();
    responseDto.setSupermarketId(supermarket.getSupermarketId());
    responseDto.setItemsNames(items);
    return responseDto;
  }
}
