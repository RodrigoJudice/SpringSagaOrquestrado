package com.git.judice.orchestrator.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;
import com.git.judice.orchestrator.application.ports.in.WorkflowInputPort;
import com.git.judice.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatedSaleUseCase implements WorkflowInputPort {

  private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

  @Override
  public void execute(Sale sale) {
    log.info("Início da separação do estoque.");
    sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
    log.info("Enviado para fila da separação de estoque.");
  }

  @Override
  public boolean isCalledByTheEvent(SaleEvent saleEvent) {
    return SaleEvent.CREATED_SALE.equals(saleEvent);
  }

}