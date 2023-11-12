package com.git.judice.sale.application.ports.out;

import com.git.judice.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);

}