package com.guitargrid.server.stripeAPI;

import com.guitargrid.server.model.cart.CartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stripe")
@CrossOrigin
public class StripeController {

    @Autowired
    private StripeClient stripeClient;

    @PostMapping("/checkout")
    public StripeResponse createCheckoutSession(@RequestBody List<CartProduct> cartProducts) {
        try {
            return stripeClient.createCheckoutSession(cartProducts);
        } catch (Exception e) {
            return null;
        }
    }

}
