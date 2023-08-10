package com.example.infrastructure.persistence.assembler;

import com.example.domain.entity.Order;
import com.example.domain.entity.OrderItem;
import com.example.infrastructure.persistence.entity.OrderItemPo;
import com.example.infrastructure.persistence.entity.OrderPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDataMapper {
    OrderDataMapper mapper = getMapper(OrderDataMapper.class);

    OrderPo toOrderPo(Order order);

    OrderItemPo toOrderItem(OrderItem orderItem);

    List<OrderItemPo> toOrderItems(List<OrderItem> orderItems);

    @Mappings({
            @Mapping(target = "id", source = "savedOrder.id"),
            @Mapping(target = "customerId", source = "savedOrder.customerId"),
            @Mapping(target = "status", source = "savedOrder.status"),
            @Mapping(target = "totalPrice", source = "savedOrder.totalPrice"),
            @Mapping(target = "createTime", source = "savedOrder.createTime"),
            @Mapping(target = "orderItems", source = "orderItemPos")
    })
    Order toOrderDo(OrderPo savedOrder, List<OrderItemPo> orderItemPos);
}