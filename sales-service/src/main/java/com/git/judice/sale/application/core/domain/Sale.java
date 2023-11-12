package com.git.judice.sale.application.core.domain;

import com.git.judice.sale.application.core.domain.enums.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
