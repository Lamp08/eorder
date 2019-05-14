package com.omnicurius.ecommerce.repository;

import com.omnicurius.ecommerce.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCrudRepository extends JpaRepository<Item,Integer>{}
