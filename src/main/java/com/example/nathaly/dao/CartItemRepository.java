package com.example.nathaly.dao;

import com.example.nathaly.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
