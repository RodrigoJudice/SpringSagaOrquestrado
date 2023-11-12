package com.git.judice.payment.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.git.judice.payment.adapters.out.repository.entity.UserEntity;
import com.git.judice.payment.application.core.domain.User;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}