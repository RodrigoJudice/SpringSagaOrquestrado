package com.git.judice.sale.adapters.out.message;

import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.core.domain.enums.SaleEvent;
import lombok.Data;

@Data
public class SaleMessage {

    private final Sale sale;
    private final SaleEvent event;
}
