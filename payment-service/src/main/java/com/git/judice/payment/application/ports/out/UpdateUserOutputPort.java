package com.git.judice.payment.application.ports.out;

import com.git.judice.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
