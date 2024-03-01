package com.guitargrid.server.service;

import com.guitargrid.server.mapper.GuitarMapper;
import com.guitargrid.server.repository.GuitarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuitarServiceTest {

    @Mock
    private GuitarRepository guitarRepository;

    @Mock
    private GuitarMapper guitarMapper;

    @InjectMocks
    private GuitarService guitarService;

    @Test
    void shouldThrowNoSuchElementExceptionWhenGuitarNotFound() {
        UUID id = UUID.randomUUID();
        when(guitarRepository.findById(id)).thenReturn(Optional.empty());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> guitarService.getGuitarById(id));
        assertEquals("Guitar not found", exception.getMessage());
    }
}