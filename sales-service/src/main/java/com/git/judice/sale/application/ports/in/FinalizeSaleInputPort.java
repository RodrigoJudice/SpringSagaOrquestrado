package com.git.judice.sale.application.ports.in;

import com.git.judice.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);

}
