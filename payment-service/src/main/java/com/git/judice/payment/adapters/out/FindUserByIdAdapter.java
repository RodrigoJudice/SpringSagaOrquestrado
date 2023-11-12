package com.git.judice.payment.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.payment.adapters.out.repository.UserRepository;
import com.git.judice.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.git.judice.payment.application.core.domain.User;
import com.git.judice.payment.application.ports.out.FindUserByIdOutputPort;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        var userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }

}