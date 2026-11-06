package com.example.nathaly.services;

import com.example.nathaly.dao.CartRepository;
import com.example.nathaly.entities.Cart;
import com.example.nathaly.entities.CartItem;
import com.example.nathaly.entities.Customer;
import com.example.nathaly.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;
@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
        //get cart from the purchase
        Cart cart=purchase.getCart();

        //generate tracking number and save it on the cart
        String orderTrackingNumber=generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //attach each cart item to cart
        Set<CartItem>cartItems=purchase.getCartItems();
        cartItems.forEach(item->cart.add(item));

        //connect cart and customer
        Customer customer=purchase.getCustomer();
        cart.setCustomer(customer);
        customer.add(cart);

        //mark order as placed
        cart.setStatus(StatusType.ordered);

        //save cart(cascades to its cart items)
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
