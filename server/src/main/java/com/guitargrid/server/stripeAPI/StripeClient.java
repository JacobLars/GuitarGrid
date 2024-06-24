package com.guitargrid.server.stripeAPI;


import com.guitargrid.server.model.cart.CartProduct;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;

import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import com.stripe.param.checkout.SessionCreateParams.LineItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StripeClient {


    @Value("${stripe.key}")
    private String stripeKey;

    public StripeResponse createCheckoutSession(List<CartProduct> cartProducts) throws StripeException {
        Stripe.apiKey = stripeKey;
        List<LineItem> lineItems = cartProducts.stream()
                .map(cartProduct -> new LineItem.Builder()
                        .setPriceData(
                                new LineItem.PriceData.Builder()
                                        .setCurrency("usd")
                                        .setUnitAmount((long) (cartProduct.getPrice() * 100))
                                        .setProductData(
                                                new LineItem.PriceData.ProductData.Builder()
                                                        .setName(cartProduct.getName())
                                                        .build()
                                        )
                                        .build()
                        )
                        .setQuantity((long) cartProduct.getQuantity())
                        .build())
                .collect(Collectors.toList());

        SessionCreateParams params =
                SessionCreateParams.builder()
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl("http://localhost:3000/success")
                        .setCancelUrl("http://localhost:3000/cancel")
                        .addAllLineItem(lineItems)
                        .build();

        Session session = Session.create(params);
        return new StripeResponse(getCheckoutUrl(session.getId()));
    }

    private String getCheckoutUrl(String sessionId) {
        try {
            return Session.retrieve(sessionId).getUrl();
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }

}
