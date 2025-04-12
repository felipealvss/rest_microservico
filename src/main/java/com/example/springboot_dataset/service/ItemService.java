package com.example.springboot_dataset.service;

import com.example.springboot_dataset.model.Item;
import com.example.springboot_dataset.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public ResponseEntity<Item> getItemById(String id){
        return itemRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Item>> findByNameContainingIgnoreCase(String name){
        List<Item> items = itemRepository.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(items);
    }

    public ResponseEntity<List<Item>> findByCategory(String category){
        List<Item> items = itemRepository.findByCategory(category);
        return ResponseEntity.ok(items);
    }

    public ResponseEntity<List<Item>> findByPriceBetween(Double min, Double max){
        List<Item> items = itemRepository.findByPriceBetween(min, max);
        return ResponseEntity.ok(items);
    }

    public Item createItem(Item item){
        return itemRepository.save(item);
    }
}
