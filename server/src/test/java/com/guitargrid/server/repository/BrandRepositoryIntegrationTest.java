package com.guitargrid.server.repository;

import com.guitargrid.server.model.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class BrandRepositoryIntegrationTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void shouldFindBrandByIdAndReturnBrand() {
        Brand newBrand = Brand.builder()
                .name("Fender")
                .logo("fender.png")
                .build();
        Brand savedBrand = brandRepository.save(newBrand);
        Brand foundBrand = brandRepository.findById(savedBrand.getId()).orElse(null);
        assert foundBrand != null;
        assertThat(foundBrand.getId()).isNotNull();
        assertThat(foundBrand.getName()).isEqualTo(newBrand.getName());
    }

}
