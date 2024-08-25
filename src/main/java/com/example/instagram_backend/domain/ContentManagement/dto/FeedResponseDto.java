package com.example.instagram_backend.domain.ContentManagement.dto;

import com.example.instagram_backend.domain.ContentManagement.dao.Media;
import com.example.instagram_backend.domain.UserInteractions.dao.Comment;
import com.example.instagram_backend.domain.UserInteractions.dao.Like;

import java.util.List;

public class FeedResponseDto {
    private Long postId;
    private String content;
    private String rgtDate;
    private List<Comment> comments;
    private List<Like> likes;
    private long userId;
}
