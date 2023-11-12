package com.git.judice.sale.application.ports.in;

import com.git.judice.sale.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final Integer id);

}