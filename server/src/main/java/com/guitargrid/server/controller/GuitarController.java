package com.guitargrid.server.controller;

import com.guitargrid.server.model.Guitar;
import com.guitargrid.server.service.GuitarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guitars")
public class GuitarController {


    private final GuitarService guitarService;

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping
    public List<Guitar> getAllGuitars() {
        return guitarService.getAllGuitars();
    }

    @PostMapping
    public Guitar saveGuitar(@RequestBody Guitar guitar) {
        return guitarService.saveGuitar(guitar);
    }




}
