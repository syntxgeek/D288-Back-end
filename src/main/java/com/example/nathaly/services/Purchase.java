package com.example.nathaly.services;

import com.example.nathaly.entities.Cart;
import com.example.nathaly.entities.CartItem;
import com.example.nathaly.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
