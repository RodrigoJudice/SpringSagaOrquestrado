package com.git.judice.payment.application.ports.out;

import com.git.judice.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}