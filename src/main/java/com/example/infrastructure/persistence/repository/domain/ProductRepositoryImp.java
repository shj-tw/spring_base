package com.example.infrastructure.persistence.repository.domain;

import com.example.domain.entity.Product;
import com.example.domain.repository.ProductRepository;
import com.example.infrastructure.persistence.assembler.ProductDataMapper;
import com.example.infrastructure.persistence.repository.JpaProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class ProductRepositoryImp implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductDataMapper mapper = ProductDataMapper.MAPPER;


    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream().map(mapper::toDo).collect(Collectors.toList());
    }
}
