package com.endava.supermarket.repository;

import com.endava.supermarket.model.Item;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Item, String> {
  Optional<Item> findById(String id);
}
