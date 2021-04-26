package com.endava.supermarket.service;

import com.endava.supermarket.model.Purchase;

public interface PurchaseService {

  Purchase findPurchaseById(String id);

  Purchase buyItemsFromSupermarket(Purchase purchaseToSave);
}
