package com.example.instagram_backend.domain.UserInfoManagement.dao;


import com.example.instagram_backend.domain.ContentManagement.dao.Post;
import com.example.instagram_backend.domain.SocialRelations.dao.Relation;
import com.example.instagram_backend.domain.UserInteractions.dao.Chat;
import com.example.instagram_backend.domain.UserInteractions.dao.Like;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Builder // 빌더 패턴
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false )
    private String nickname;

    //일대일
    @OneToOne(mappedBy="users", fetch=FetchType.LAZY)
    private Profile profile;

    public User update(String nickname){
        this.nickname = nickname;
        return this;
    }
}
