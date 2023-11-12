package com.git.judice.orchestrator.application.core.usecase;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;
import com.git.judice.orchestrator.application.ports.in.WorkflowInputPort;
import com.git.judice.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentFailureUseCase implements WorkflowInputPort {

  private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

  @Override
  public void execute(Sale sale) {
    log.info("Erro no pagamento.");
    sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
    sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
    log.info("Rollback do estoque e cancelamento da venda postados na fila.");
  }

  @Override
  public boolean isCalledByTheEvent(SaleEvent saleEvent) {
    return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
  }

}