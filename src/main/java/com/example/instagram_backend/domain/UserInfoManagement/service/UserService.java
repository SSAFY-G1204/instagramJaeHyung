package com.example.instagram_backend.domain.UserInfoManagement.service;


import com.example.instagram_backend.domain.UserInfoManagement.dao.User;
import com.example.instagram_backend.domain.UserInfoManagement.dto.UserRelationDto;
import com.example.instagram_backend.domain.UserInfoManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<UserRelationDto> findUsersByNickname(String keyword) {
        return userRepository.findUsersWithRelationIds(keyword);
    }



}




