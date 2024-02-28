package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.service.GuitarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/guitars")
public class GuitarController {


    private final GuitarService guitarService;

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping
    public GuitarListResponse getAllGuitars() {
        return guitarService.getAllGuitars();
    }

    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public GuitarResponse saveGuitar(@RequestBody GuitarRequest guitarRequest, @PathVariable UUID brandId) {
        return guitarService.saveGuitar(guitarRequest, brandId);
    }

}
