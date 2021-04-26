package com.endava.supermarket.controller;

import com.endava.supermarket.dto.AddItmsToSpmktRequestDto;
import com.endava.supermarket.dto.AddItmsToSpmktResponseDto;
import com.endava.supermarket.dto.CreateItemRequestDto;
import com.endava.supermarket.dto.CreateSupermarketRequestDto;
import com.endava.supermarket.dto.ItemResponseDto;
import com.endava.supermarket.dto.SupermarketResponseDto;
import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Supermarket;
import com.endava.supermarket.service.SupermarketService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(value = "/v1/supermarkets",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class SupermarketController {

  private final SupermarketService supermarketService;
  private final ModelMapper modelMapper;

  @PostMapping(value = "/create-item")
  public ResponseEntity<String> createItem(
      @Valid @RequestBody CreateItemRequestDto dto,
      UriComponentsBuilder uribuilder) {
    Item itemToSave = modelMapper.map(dto, Item.class);
    Item savedItem = supermarketService.createItem(itemToSave);
    uribuilder.replacePath("/v1/supermarkets/items/" + savedItem.getItemId());
    return ResponseEntity.ok(uribuilder.toUriString());
  }

  @GetMapping(value = "/items/{id}")
  public ResponseEntity<ItemResponseDto> listItem(@PathVariable String id) {
    Item item = supermarketService.findItemById(id);
    return ResponseEntity.ok(modelMapper.map(item, ItemResponseDto.class));
  }

  @PostMapping(value = "/create-supermarket")
  public ResponseEntity<String> createSupermarket(
      @Valid @RequestBody CreateSupermarketRequestDto dto,
      UriComponentsBuilder uribuilder) {
    Supermarket supermarketToSave = modelMapper.map(dto, Supermarket.class);
    Supermarket savedSupermarket = supermarketService.createSupermarket(supermarketToSave);
    uribuilder.replacePath("/v1/supermarkets/" + savedSupermarket.getSupermarketId());
    return ResponseEntity.ok(uribuilder.toUriString());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<SupermarketResponseDto> getSupermarketById(@PathVariable String id) {
    SupermarketResponseDto supermarketResponseDto = supermarketService.findSupermarketById(id);
    return ResponseEntity.ok(supermarketResponseDto);
  }

  @PostMapping(value = "/add-items-to-supermarket")
  public ResponseEntity<AddItmsToSpmktResponseDto> addItemsToSupermarket(
      @Valid @RequestBody AddItmsToSpmktRequestDto dto) {
    return ResponseEntity.ok(supermarketService.addItemsToSupermarket(dto));
  }
}
