package com.example.infrastructure.persistence.entity;

import com.example.domain.entity.ProductStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class ProductPo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    private String price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
