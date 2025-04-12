package com.example.springboot_dataset.repository;

import com.example.springboot_dataset.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByNameContainingIgnoreCase(String name);
    List<Item> findByCategory(String category);
    List<Item> findByPriceBetween(Double min, Double max);
}
