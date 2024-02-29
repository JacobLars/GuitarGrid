package com.guitargrid.server.service;

import com.guitargrid.server.mapper.BrandMapper;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandMapper brandMapper;

    @InjectMocks
    private BrandService brandService;

    @Test
    void shouldThrowNoSuchElementException() {
        NoSuchElementException exception =
                assertThrows(NoSuchElementException.class, () -> brandService.getBrandById(null));
        assertEquals(NoSuchElementException.class, exception.getClass());
        assertEquals("Brand not found", exception.getMessage());
    }
}