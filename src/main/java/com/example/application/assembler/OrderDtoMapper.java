package com.example.application.assembler;

import com.example.domain.entity.Order;
import com.example.domain.entity.OrderItem;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderItemDto;
import com.example.presentation.vo.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDtoMapper {
    OrderDtoMapper MAPPER = getMapper(OrderDtoMapper.class);

    OrderItem toOrderItemDto(OrderItemDto orderItem);

    @Mapping(target = "orderItems", source = "orderRequest.orderItemDtos")
    Order toOrderDo(OrderRequest orderRequest, String customerId);


    OrderItemDto toOrderItemDto(OrderItem orderItem);

    @Mapping(target = "orderItems", source = "orderItems")
    OrderDto toOrderDto(Order order);
}
