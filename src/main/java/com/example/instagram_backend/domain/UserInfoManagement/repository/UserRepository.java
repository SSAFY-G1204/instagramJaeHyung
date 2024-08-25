package com.example.instagram_backend.domain.UserInfoManagement.repository;

import com.example.instagram_backend.domain.UserInfoManagement.dao.User;
import com.example.instagram_backend.domain.UserInfoManagement.dto.UserRelationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM instagram.users WHERE nickname LIKE %:keyword%", nativeQuery = true)
    List<User> findUsersByNickname(@Param("keyword") String keyword);

    List<User> findUserByUserId(Long userId);

    @Query("SELECT new com.example.instagram_backend.domain.UserInfoManagement.dto.UserRelationDto(u.userId, u.email, u.password, u.name, u.provider, u.nickname, r.relationId) " +
            "FROM User u JOIN u.relations r WHERE u.nickname LIKE %:keyword%")
    List<UserRelationDto> findUsersWithRelationIds(@Param("keyword") String keyword);
}