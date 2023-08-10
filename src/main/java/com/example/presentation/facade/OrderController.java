package com.example.presentation.facade;

import com.example.application.service.OrderApplicationService;
import com.example.presentation.vo.OrderDto;
import com.example.presentation.vo.OrderRequest;
import com.example.presentation.vo.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    @PostMapping
    public OrderDto submit(@RequestBody OrderRequest orderRequest,
                           @RequestParam(name = "customerId") String customerId) {
        return orderApplicationService.createOrder(orderRequest, customerId);
    }
}
