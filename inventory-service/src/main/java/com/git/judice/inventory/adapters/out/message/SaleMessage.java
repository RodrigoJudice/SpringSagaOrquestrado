package com.git.judice.inventory.adapters.out.message;

import com.git.judice.inventory.application.core.domain.Sale;
import com.git.judice.inventory.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

  private Sale sale;
  private SaleEvent event;
}