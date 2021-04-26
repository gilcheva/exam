package com.endava.supermarket.repository;

import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Supermarket;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
  Optional<Item> findById(String id);
  List<Item> findAllBySupermarket (Supermarket supermarket);
}
