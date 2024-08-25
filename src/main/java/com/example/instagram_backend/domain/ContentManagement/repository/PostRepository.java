package com.example.instagram_backend.domain.ContentManagement.repository;


import com.example.instagram_backend.domain.ContentManagement.dao.Post;
import com.example.instagram_backend.domain.ContentManagement.dto.FeedResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserUserId(Long userId);

//    @Query("SELECT new com.example.instagram_backend.domain.ContentManagement.dto.FeedResponseDto(p.postId, p.content, p.rgtDate, u.userId) " +
//            "FROM Post p " +
//            "JOIN p.user u " +
//            "WHERE u.userId IN :userIds")
//    List<FeedResponseDto> findFeedResponsesByUserIds(@Param("userIds") List<Long> userIds);


}
