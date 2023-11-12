package com.git.judice.inventory.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.application.core.domain.Sale;
import com.git.judice.inventory.application.core.domain.enums.SaleEvent;
import com.git.judice.inventory.application.ports.in.CreditInventoryInputPort;
import com.git.judice.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.git.judice.inventory.application.ports.out.SendToKafkaOutputPort;
import com.git.judice.inventory.application.ports.out.UpdateInventoryOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreditInventoryUseCase implements CreditInventoryInputPort {

  private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

  private final UpdateInventoryOutputPort updateInventoryOutputPort;

  private final SendToKafkaOutputPort sendToKafkaOutputPort;

  @Override
  public void credit(Sale sale) {
    var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
    inventory.creditQuantity(sale.getQuantity());
    updateInventoryOutputPort.update(inventory);
    sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
  }

}