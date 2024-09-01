package com.example.instagram_backend.domain.ContentManagement.dto;

import com.example.instagram_backend.domain.ContentManagement.dao.Media;
import com.example.instagram_backend.domain.UserInfoManagement.dao.User;
import com.example.instagram_backend.domain.UserInteractions.dao.Comment;
import com.example.instagram_backend.domain.UserInteractions.dao.Like;
import com.example.instagram_backend.domain.UserInteractions.dto.CommentResponseDto;
import com.example.instagram_backend.domain.UserInteractions.dto.LikeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FeedResponseDto {
    private Long postId;
    private String content;
    private String rgtDate;
    private Long userId;

    private List<MediaResponseDto> medias;
    private List<LikeResponseDto> likes;
    private List<CommentResponseDto> comments;

}
