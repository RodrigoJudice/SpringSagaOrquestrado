package com.git.judice.payment.application.ports.out;

import com.git.judice.payment.application.core.domain.Sale;
import com.git.judice.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
