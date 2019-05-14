package com.omnicurius.ecommerce.controllers;

import com.omnicurius.ecommerce.Models.*;
import com.omnicurius.ecommerce.repository.CartCrudRepository;
import com.omnicurius.ecommerce.repository.CartDetailCrudRepository;
import com.omnicurius.ecommerce.repository.ItemCrudRepository;
import com.omnicurius.ecommerce.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/ecommerce/order")
public class OrderController {

    @Autowired
    private CartCrudRepository  cartCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private ItemCrudRepository itemCrudRepository;

    @Autowired
    private CartDetailCrudRepository cartDetailCrudRepository;

    @PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addOrders(@RequestBody List<OrderDto> orderDto){
        List<Cart> cartList = new ArrayList<>();
        List<CartDetails> cartDetailList = new ArrayList<>();

        for(OrderDto dto:orderDto){
            Cart cart = new Cart();
            cart.setCartId(dto.getOrderId());
            User user = userCrudRepository.findById(dto.getEmailId()).get();
            cart.setUser(user);
            cart.setCreatedOn(new Date());
            cart.setUpdatedOn(new Date());
            cartList.add(cart);

            for(Map.Entry<Integer,Integer> entry:dto.getMap().entrySet()){
                Item item = itemCrudRepository.findById(entry.getKey()).get();
                if(item.getQuantity()>entry.getValue()){
                    CartDetails cartDetails = new CartDetails();
                    cartDetails.setItem(item);
                    cartDetails.setQuantity(entry.getValue());
                    item.setQuantity(item.getQuantity()-entry.getValue());
                    System.out.println(item.getQuantity());
                    cartDetails.setCart(cart);
                    cartDetails.setCreatedOn(new Date());
                    cartDetails.setUpdatedOn(new Date());
                    cartDetailList.add(cartDetails);

                }
                else {
                    cartList.remove(cart);
                    break;
                }

        }
       }
      cartCrudRepository.saveAll(cartList);
        cartDetailCrudRepository.saveAll(cartDetailList);
        return "orders added";

    }

    @GetMapping(value = "/allOrders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getAllOrders(){
        List<Cart> cartList = cartCrudRepository.findAll();
        return cartList;
    }



}
