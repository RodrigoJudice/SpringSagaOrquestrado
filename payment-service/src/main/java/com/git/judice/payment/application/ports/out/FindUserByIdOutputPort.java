package com.git.judice.payment.application.ports.out;

import java.util.Optional;

import com.git.judice.payment.application.core.domain.User;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);

}