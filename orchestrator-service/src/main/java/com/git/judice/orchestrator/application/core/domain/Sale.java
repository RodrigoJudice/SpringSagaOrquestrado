package com.git.judice.orchestrator.application.core.domain;

import java.math.BigDecimal;

import com.git.judice.orchestrator.application.core.domain.enums.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sale {

  private Integer id;
  private Integer productId;
  private Integer userId;
  private BigDecimal value;
  private SaleStatus status;
  private Integer quantity;

}
