package com.example.springboot_dataset.controller;

import com.example.springboot_dataset.model.Item;
import com.example.springboot_dataset.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id){
        return itemService.getItemById(id);
    }
    
    @GetMapping("/by-name")
    public ResponseEntity<List<Item>> getItemByName(@RequestParam String name){
        return itemService.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Item>> getItemByCategory(@RequestParam String category){
        return itemService.findByCategory(category);
    }

    @GetMapping("by-price")
    public ResponseEntity<List<Item>> getItemByPriceBetween(@RequestParam Double min, @RequestParam Double max){
        return itemService.findByPriceBetween(min, max);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }
}
