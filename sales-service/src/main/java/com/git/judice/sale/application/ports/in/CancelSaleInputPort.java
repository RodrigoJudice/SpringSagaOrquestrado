package com.git.judice.sale.application.ports.in;

import com.git.judice.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);

}