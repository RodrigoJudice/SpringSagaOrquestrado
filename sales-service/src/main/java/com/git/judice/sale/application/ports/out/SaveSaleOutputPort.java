package com.git.judice.sale.application.ports.out;

import com.git.judice.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    Sale save(Sale sale);
}
