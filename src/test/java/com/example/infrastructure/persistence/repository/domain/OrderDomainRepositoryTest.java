package com.example.infrastructure.persistence.repository.domain;

import com.example.domain.entity.Order;
import com.example.domain.entity.OrderItem;
import com.example.domain.entity.OrderStatus;
import com.example.infrastructure.persistence.assembler.OrderDataMapper;
import com.example.infrastructure.persistence.entity.OrderPo;
import com.example.infrastructure.persistence.repository.JpaOrderItemRepository;
import com.example.infrastructure.persistence.repository.JpaOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest(classes = OrderDomainRepositoryTest.class)
@RunWith(MockitoJUnitRunner.class)
class OrderDomainRepositoryTest {

    @Mock
    private JpaOrderItemRepository jpaOrderItemRepository;
    @Mock
    private JpaOrderRepository jpaOrderRepository;
    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private OrderDataMapper orderDataMapper;

    @InjectMocks
    private OrderDomainRepository orderDomainRepository;

    @Test
    void should_save_order_items_and_order() {
        Order order = getMockOrder();
        when(jpaOrderItemRepository.saveAll(anyIterable())).thenAnswer(invocation -> invocation.getArgument(0));
        when(jpaOrderRepository.save(any(OrderPo.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Order savedOrder = orderDomainRepository.save(order);

        assertThat(savedOrder.getId()).isEqualTo("1");
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.CREATED);
        assertThat(savedOrder.getCustomerId()).isEqualTo("2");
        assertThat(savedOrder.getTotalPrice()).isEqualTo("12.34");

        assertThat(savedOrder.getOrderItems()).hasSize(1);
        OrderItem firstOrderItem = savedOrder.getOrderItems().get(0);
        assertThat(firstOrderItem.getId()).isEqualTo("3");
        assertThat(firstOrderItem.getOrderId()).isEqualTo("1");
        assertThat(firstOrderItem.getProductId()).isEqualTo("1");
        assertThat(firstOrderItem.getQuantity()).isEqualTo(5);
    }

    private Order getMockOrder() {
        return Order.builder()
                .id("1")
                .customerId("2")
                .status(OrderStatus.CREATED)
                .totalPrice("12.34")
                .orderItems(List.of(getMockOrderItem()))
                .build();
    }

    private OrderItem getMockOrderItem() {
        return OrderItem.builder()
                .id("3")
                .productId("1")
                .productName("product name")
                .price("5.50")
                .quantity(5)
                .build();
    }
}