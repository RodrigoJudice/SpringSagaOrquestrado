package com.git.judice.sale.application.ports.in;

import com.git.judice.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {


    void create(Sale sale);

}
