package com.omnicurius.ecommerce.controllers;

import com.omnicurius.ecommerce.Models.Item;
import com.omnicurius.ecommerce.repository.ItemCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/item")
public class ItemController {

    @Autowired
    private ItemCrudRepository crudRepository;

    @GetMapping(value = "/getAllItems",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems(){
        List<Item> itemList = crudRepository.findAll();
        return itemList;
    }

    @PutMapping(value = "/insertItem", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertItem(@RequestBody Item item){
        crudRepository.save(item);
        return "successfully inserted item";
    }

    @DeleteMapping(value = "/deleteItem/{itemId}/{quantity}")
    public String deleteItem(@PathVariable("itemId") int itemId, @PathVariable("quantity") int quantity){
        Item item = crudRepository.findById(itemId).get();
        item.setQuantity(item.getQuantity()-quantity);
        crudRepository.save(item);
        return "item "+itemId+" deleted by "+quantity+" quantity";
    }

    @PostMapping(value = "/updateItem")
    public String addItem(@RequestBody Item item){
        crudRepository.save(item);
        return "item updated";
    }



}
