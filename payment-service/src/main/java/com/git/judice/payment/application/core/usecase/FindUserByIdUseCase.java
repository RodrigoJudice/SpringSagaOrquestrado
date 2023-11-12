package com.git.judice.payment.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.payment.application.core.domain.User;
import com.git.judice.payment.application.ports.in.FindUserByIdInputPort;
import com.git.judice.payment.application.ports.out.FindUserByIdOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    @Override
    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

}