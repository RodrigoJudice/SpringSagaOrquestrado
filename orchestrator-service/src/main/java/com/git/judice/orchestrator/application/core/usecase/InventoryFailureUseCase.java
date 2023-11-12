package com.git.judice.orchestrator.application.core.usecase;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;
import com.git.judice.orchestrator.application.ports.in.WorkflowInputPort;
import com.git.judice.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryFailureUseCase implements WorkflowInputPort {

  private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

  @Override
  public void execute(Sale sale) {
    log.info("Erro ao debitar estoque.");
    sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
    log.info("Cancelamento da venda postado na fila.");
  }

  @Override
  public boolean isCalledByTheEvent(SaleEvent saleEvent) {
    return SaleEvent.INVENTORY_ERROR.equals(saleEvent);
  }

}