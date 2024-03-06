package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.service.GuitarService;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("api/v1/guitars")
@CrossOrigin
public class GuitarController {


    private final GuitarService guitarService;

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

/*    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public GuitarResponse saveGuitar(@RequestBody GuitarRequest guitarRequest, @PathVariable UUID brandId) {
        return guitarService.saveGuitar(guitarRequest, brandId);
    }*/

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(NOT_FOUND)
    private String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }


}
