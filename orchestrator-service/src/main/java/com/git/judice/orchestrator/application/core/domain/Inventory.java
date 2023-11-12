package com.git.judice.orchestrator.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Inventory {

  private Integer id;
  private Integer productId;
  private Integer quantity;

}
