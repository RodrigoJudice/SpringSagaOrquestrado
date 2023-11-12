package com.git.judice.inventory.application.ports.in;

import com.git.judice.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

  void credit(Sale sale);

}