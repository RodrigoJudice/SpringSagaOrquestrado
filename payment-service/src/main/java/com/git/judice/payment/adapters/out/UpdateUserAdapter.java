package com.git.judice.payment.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.payment.adapters.out.repository.UserRepository;
import com.git.judice.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.git.judice.payment.application.core.domain.User;
import com.git.judice.payment.application.ports.out.UpdateUserOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }

}