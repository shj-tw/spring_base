package com.example.infrastructure.persistence.repository;

import com.example.common.base.JpaAndQueryDslExecutor;
import com.example.infrastructure.persistence.entity.OrderPo;

public interface JpaOrderRepository extends JpaAndQueryDslExecutor<OrderPo,
        String> {
}
