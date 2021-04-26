package com.endava.supermarket.controller;

import com.endava.supermarket.dto.PurchaseParamsDto;
import com.endava.supermarket.dto.PurchaseResponseDto;
import com.endava.supermarket.model.Purchase;
import com.endava.supermarket.service.PurchaseService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/purchases",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class PurchaseController {

  private final PurchaseService purchaseService;
  private final ModelMapper modelMapper;

  @PostMapping(value = "/buy-items")
  public ResponseEntity<String> buyItemsFromSupermarket(@Valid PurchaseParamsDto dto,
      UriComponentsBuilder uribuilder) {
    Purchase purchaseToSave = modelMapper.map(dto, Purchase.class);
    Purchase savedPurchase = purchaseService.buyItemsFromSupermarket(purchaseToSave);
    uribuilder.replacePath("/v1/purchases/items/" + savedPurchase.getPurchaseId());
    return ResponseEntity.ok(uribuilder.toUriString());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PurchaseResponseDto> listPurchases(@PathVariable String id) {
    Purchase purchase = purchaseService.findPurchaseById(id);
    return ResponseEntity.ok(modelMapper.map(purchase, PurchaseResponseDto.class));
  }
}
