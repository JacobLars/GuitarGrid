package com.guitargrid.server.stripeAPI;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirstStripe {


    @Value("${stripe.key}")
    private String stripeKey;

    public void create() throws StripeException {
        Stripe.apiKey = stripeKey;
        System.out.println(stripeKey);
        ProductCreateParams productParams =
                ProductCreateParams.builder()
                        .setName("Test Product")
                        .setDescription("Test product")
                        .build();
        Product product = Product.create(productParams);
        System.out.println("Success! Here is your starter product id: " + product.getId());

        PriceCreateParams params =
                PriceCreateParams
                        .builder()
                        .setProduct(product.getId())
                        .setCurrency("usd")
                        .setUnitAmount(1L)
                        .build();
        Price price = Price.create(params);
        System.out.println("Success! Here is your starter product price id: " + price.getId());
    }


}
