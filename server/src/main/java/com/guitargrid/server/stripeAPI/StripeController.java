package com.guitargrid.server.stripeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe")
public class StripeController {

    @Autowired
    private FirstStripe firstStripe;

    @PostMapping("/create")
    public String create() {
        try {
            firstStripe.create();
            return "Success!";
        } catch (Exception e) {
            return "Error!";
        }
    }

}
