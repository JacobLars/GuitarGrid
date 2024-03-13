package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldFindProductByIdAndReturnProduct() {
        Guitar newGuitar = createElectricGuitarEntity();
        Guitar savedGuitar = productRepository.save(newGuitar);
        Product foundGuitar = productRepository.findById(savedGuitar.getId()).orElse(null);
        assert foundGuitar != null;
        assertThat(foundGuitar.getId()).isNotNull();
        assertThat(foundGuitar.getName()).isEqualTo(newGuitar.getName());
        assertThat(foundGuitar.getCategory()).isEqualTo(newGuitar.getCategory());
    }
}
