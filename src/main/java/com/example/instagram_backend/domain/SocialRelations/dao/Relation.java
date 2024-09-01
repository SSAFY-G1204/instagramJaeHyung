package com.example.instagram_backend.domain.SocialRelations.dao;

import com.example.instagram_backend.domain.UserInfoManagement.dao.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Builder // 빌더 패턴
@Table(name = "relations")
public class Relation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;

    //팔로잉을 하는 사람
    @ManyToOne
    @JoinColumn(name = "userId")
    private User users;

    //팔로우를 하는 사람
    private Long followerId;

}
