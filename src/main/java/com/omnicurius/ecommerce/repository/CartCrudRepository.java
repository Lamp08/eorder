package com.omnicurius.ecommerce.repository;

import com.omnicurius.ecommerce.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartCrudRepository extends JpaRepository<Cart,Integer> {
}
