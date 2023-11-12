package com.git.judice.orchestrator.adapters.out.message;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

  private Sale sale;

  private SaleEvent event;

}