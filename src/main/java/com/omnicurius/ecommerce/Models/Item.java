package com.omnicurius.ecommerce.Models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="item")
public class Item {

    @Id

    private int item_id;

    private String name;

    private Double price;

    private int quantity;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<CartDetails> cartDetails;

    public List<CartDetails> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int email_id) {
        this.item_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
