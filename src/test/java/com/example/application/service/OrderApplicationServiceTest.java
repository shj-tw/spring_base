package com.example.application.service;

import com.example.application.assembler.OrderDtoMapper;
import com.example.domain.repository.OrderRepository;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderItemDto;
import com.example.presentation.vo.OrderRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest(classes = OrderApplicationService.class)
@RunWith(SpringRunner.class)
class OrderApplicationServiceTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean(answer = Answers.CALLS_REAL_METHODS)
    private OrderDtoMapper mapper;

    @Autowired
    private OrderApplicationService orderApplicationService;

    @Test
    void should_save_order_with_one_item() {
        OrderRequest orderDetail = new OrderRequest();
        OrderItemDto orderItemDto = new OrderItemDto("1", "product name", 1);
        orderDetail.setOrderItemDtos(List.of(orderItemDto));
        orderDetail.setTotalPrice("10.00");
        when(orderRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        OrderDto order = orderApplicationService.createOrder(orderDetail, "1");

        assertThat(order.getTotalPrice()).isEqualTo("10.00");
        assertThat(order.getTotalPrice()).isEqualTo("10.00");
        assertThat(order.getOrderItems()).hasSize(1);
        OrderItemDto orderItem = order.getOrderItems().get(0);
        assertThat(orderItem.getProductId()).isEqualTo("1");
        assertThat(orderItem.getProductName()).isEqualTo("product name");
        assertThat(orderItem.getQuantity()).isEqualTo(1);
    }
}