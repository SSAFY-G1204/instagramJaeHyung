package com.example.instagram_backend.domain.ContentManagement.service;


import com.example.instagram_backend.domain.ContentManagement.dao.Post;
import com.example.instagram_backend.domain.ContentManagement.dto.FeedResponseDto;
import com.example.instagram_backend.domain.ContentManagement.repository.PostRepository;
import com.example.instagram_backend.domain.SocialRelations.dao.Relation;
import com.example.instagram_backend.domain.SocialRelations.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RelationRepository relationRepository;


    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUserUserId(userId);
    }

    // 사용자가 팔로잉 한 사람들이 작성한 포스트들을 찾는 메서드
    public List<FeedResponseDto> findFolollowingPostsByUserId(Long userId) {

        // 관계 테이블에서 내가 파리미터로 준 userId를 follower로 두고 있는 관계들을 찾는다.
        List<Relation> relations = relationRepository.findRelationByFollowerId(userId);
        // 사용자에게 내보내줄 객체 만들고
        List<Post> posts = new ArrayList<Post>();
        // relation 관계에서 userId찾고 찾은 userId 기반으로 post 객체들을 찾는다.

        // 팔로우하고 있는 사용자들의 userId를 추출하여 List<Long>로 변환
        List<Long> userIds = relations.stream()
                .map(relation -> relation.getUsers().getUserId())
                .collect(Collectors.toList());

        //최종 리턴은 여기서!!!!
        if (!userIds.isEmpty()) {
            List<FeedResponseDto> feedResponseDtos = postRepository.findFeedResponsesByUserIds(userIds);
            return feedResponseDtos;
        } else {
            // 팔로우한 사용자가 없을 경우 빈 리스트 반환
            return Collections.emptyList();
        }

//        for( int idx = 0 ; idx<relations.size(); idx++){
//            List<Post> tgtpost = findByUserId(relations.get(idx).getUsers().getUserId());
//            posts.addAll(tgtpost);
//        }
//        return posts;
    }

}
