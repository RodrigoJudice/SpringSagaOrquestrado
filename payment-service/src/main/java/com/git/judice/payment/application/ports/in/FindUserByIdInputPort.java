package com.git.judice.payment.application.ports.in;

import com.git.judice.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);

}