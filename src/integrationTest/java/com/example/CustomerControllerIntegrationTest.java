package com.example;

import com.example.infrastructure.persistence.repository.JpaCustomerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerIntegrationTest extends BaseIntegrationTest {

  @Value("classpath:result/customers.json")
  Resource expectedCustomers;

  @Autowired
  private JpaCustomerRepository jpaCustomerRepository;

  @Test
  public void findById_should_success() throws Exception {
    mockMvc.perform(get("/customers/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(Files.readString(expectedCustomers.getFile().toPath()), true));
  }
}
