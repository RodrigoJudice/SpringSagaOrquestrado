package com.git.judice.orchestrator.application.ports.out;

import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

  void send(Sale sale, SaleEvent saleEvent, String topic);

}
