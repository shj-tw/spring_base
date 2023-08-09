package com.example.infrastructure.persistence.assembler;

import com.example.domain.entity.Product;
import com.example.infrastructure.persistence.entity.ProductPo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDataMapper {

    ProductDataMapper MAPPER = getMapper(ProductDataMapper.class);

    Product toDo(ProductPo productPo);
}
