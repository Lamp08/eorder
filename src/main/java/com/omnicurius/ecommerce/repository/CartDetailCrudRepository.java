package com.omnicurius.ecommerce.repository;

import com.omnicurius.ecommerce.Models.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailCrudRepository extends JpaRepository<CartDetails,Integer> {
}
