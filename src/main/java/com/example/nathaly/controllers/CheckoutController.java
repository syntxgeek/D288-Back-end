package com.example.nathaly.controllers;

import com.example.nathaly.services.CheckoutService;
import com.example.nathaly.services.Purchase;
import com.example.nathaly.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/checkout")

public class CheckoutController {
    private final CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        return checkoutService.placeOrder(purchase);
    }

}
