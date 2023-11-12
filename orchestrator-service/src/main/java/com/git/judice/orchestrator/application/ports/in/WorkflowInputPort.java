package com.git.judice.orchestrator.application.ports.in;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

  void execute(Sale sale);

  boolean isCalledByTheEvent(SaleEvent saleEvent);

}