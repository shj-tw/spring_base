package com.example.infrastructure.persistence.repository;


import com.example.common.base.JpaAndQueryDslExecutor;
import com.example.infrastructure.persistence.entity.ProductPo;

public interface JpaProductRepository extends JpaAndQueryDslExecutor<ProductPo, String> {
}
