package com.example;

import com.example.infrastructure.persistence.repository.JpaProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerIntegrationTest extends BaseIntegrationTest {

    @Value("classpath:result/products.json")
    Resource expectedProducts;

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Test
    public void should_return_expectedProducts_when_findAll() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(Files.readString(expectedProducts.getFile().toPath()), true));
    }
}