package com.git.judice.orchestrator.application.core.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
  private Integer id;

  private Integer userId;

  private Integer saleId;

  private BigDecimal value;

  public Integer getId() {
    return id;
  }
}
