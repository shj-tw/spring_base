package com.example.infrastructure.persistence.repository;

import com.example.common.base.JpaAndQueryDslExecutor;
import com.example.infrastructure.persistence.entity.OrderItemPo;
import com.example.infrastructure.persistence.entity.OrderPo;

public interface JpaOrderItemRepository extends JpaAndQueryDslExecutor<OrderItemPo,
        String> {
}
