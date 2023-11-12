package com.git.judice.payment.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.payment.adapters.out.repository.PaymentRepository;
import com.git.judice.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.git.judice.payment.application.core.domain.Payment;
import com.git.judice.payment.application.ports.out.SavePaymentOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;

    private final PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }

}