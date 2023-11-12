package com.git.judice.sale.application.ports.out;

import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {
    void send(Sale sale, SaleEvent event);
}
