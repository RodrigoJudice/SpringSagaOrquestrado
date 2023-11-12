package com.git.judice.orchestrator.application.core.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {

  private Integer id;
  private Integer userId;
  private Integer saleId;
  private BigDecimal value;

}
