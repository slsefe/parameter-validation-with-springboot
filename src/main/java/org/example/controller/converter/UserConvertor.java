package org.example.controller.converter;

import org.example.controller.dto.UserDTO;
import org.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertor {
    public UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    @Mapping(target = "password", source = "password1")
    User UserDTOtoUser(UserDTO userDTO);
}
