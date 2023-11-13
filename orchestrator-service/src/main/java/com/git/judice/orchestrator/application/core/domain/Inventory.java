package com.git.judice.orchestrator.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

  private Integer id;
  private Integer productId;
  private Integer quantity;

}
