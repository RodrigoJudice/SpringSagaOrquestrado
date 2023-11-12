package com.git.judice.payment.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.git.judice.payment.adapters.out.repository.entity.PaymentEntity;
import com.git.judice.payment.application.core.domain.Payment;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);

}