package com.example.application.service;

import com.example.application.assembler.ProductDtoMapper;
import com.example.domain.repository.ProductRepository;
import com.example.presentation.vo.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductApplicationService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper mapper = ProductDtoMapper.MAPPER;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
