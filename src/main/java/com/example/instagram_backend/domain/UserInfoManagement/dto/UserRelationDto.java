package com.example.instagram_backend.domain.UserInfoManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRelationDto {

    private Long userId;
    private String email;
    private String password;
    private String name;
    private String provider;
    private String nickname;
    private Long relationId;
}
