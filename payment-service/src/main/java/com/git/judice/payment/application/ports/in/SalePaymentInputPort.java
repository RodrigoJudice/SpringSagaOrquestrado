package com.git.judice.payment.application.ports.in;

import com.git.judice.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}