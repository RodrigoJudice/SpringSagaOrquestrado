package com.git.judice.inventory.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import com.git.judice.inventory.application.core.domain.enums.SaleStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private Integer id;
    private Integer productId;
    private Integer userId;
    private BigDecimal value;
    private SaleStatus status;
    private Integer quantity;

}