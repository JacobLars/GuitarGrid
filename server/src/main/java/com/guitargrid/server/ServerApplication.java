package com.guitargrid.server;

import com.guitargrid.server.stripeAPI.FirstStripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        FirstStripe firstStripe = new FirstStripe();
        try {
            firstStripe.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
