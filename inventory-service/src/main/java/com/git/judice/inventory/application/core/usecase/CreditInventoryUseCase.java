package com.git.judice.inventory.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.application.core.domain.Sale;
import com.git.judice.inventory.application.ports.in.CreditInventoryInputPort;
import com.git.judice.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.git.judice.inventory.application.ports.out.UpdateInventoryOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreditInventoryUseCase implements CreditInventoryInputPort {

  private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

  private final UpdateInventoryOutputPort updateInventoryOutputPort;

  @Override
  public void credit(Sale sale) {
    var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
    inventory.creditQuantity(sale.getQuantity());
    updateInventoryOutputPort.update(inventory);

  }

}