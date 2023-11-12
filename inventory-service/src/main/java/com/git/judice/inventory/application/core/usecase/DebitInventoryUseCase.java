package com.git.judice.inventory.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.application.core.domain.Sale;
import com.git.judice.inventory.application.core.domain.enums.SaleEvent;
import com.git.judice.inventory.application.ports.in.DebitInventoryInputPort;
import com.git.judice.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.git.judice.inventory.application.ports.out.SendToKafkaOutputPort;
import com.git.judice.inventory.application.ports.out.UpdateInventoryOutputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class DebitInventoryUseCase implements DebitInventoryInputPort {

  private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

  private final UpdateInventoryOutputPort updateInventoryOutputPort;

  private final SendToKafkaOutputPort sendToKafkaOutputPort;

  @Override
  public void debit(Sale sale) {
    try {

      var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());

      if (inventory.getQuantity() < sale.getQuantity()) {
        throw new RuntimeException("Estoque insuficiente");
      }

      inventory.debitQuantity(sale.getQuantity());
      updateInventoryOutputPort.update(inventory);
      sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);

    } catch (Exception e) {
      log.error("Houve um erro = {}", e.getMessage());
      sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
  }

}