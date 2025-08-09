package com.movieapp.backend.mapper;

import com.movieapp.backend.dto.user.UserDTO;
import com.movieapp.backend.model.User;

public class UserMapper {

    public static UserDTO convertToDTO(User user) {
        if (user == null) return null;
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .build();
    }

}
