package com.guitargrid.server.stripeAPI;

import com.guitargrid.server.model.cart.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stripe")
public class StripeController {

    @Autowired
    private FirstStripe firstStripe;

    @PostMapping("/checkout")
    public String createCheckoutSession(@RequestBody List<CartProduct> cartProducts) {
        try {
            String sessionId = firstStripe.createCheckoutSession(cartProducts);
            return sessionId;
        } catch (Exception e) {
            return "Error!";
        }
    }

}
