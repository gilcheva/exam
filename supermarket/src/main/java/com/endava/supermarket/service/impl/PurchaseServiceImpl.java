package com.endava.supermarket.service.impl;

import com.endava.supermarket.model.Purchase;
import com.endava.supermarket.repository.PurchaseRepository;
import com.endava.supermarket.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;

  @Override
  public Purchase findPurchaseById(String id) {
    return null;
  }

  @Override
  public Purchase buyItemsFromSupermarket(Purchase purchaseToSave) {
    return null;
  }
}
