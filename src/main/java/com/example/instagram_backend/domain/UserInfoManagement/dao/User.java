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

    @OneToMany(mappedBy="users")
    private List<Relation> relations = new ArrayList<>();
    //일대일
    @OneToOne(mappedBy="users")
    private Profile profile;

    //users에 의해 매핑 되었다.
    @OneToMany(mappedBy ="user")
    private List<Like> likes = new ArrayList<Like>();

    @OneToMany(mappedBy ="user")
    private List<Chat> chats = new ArrayList<Chat>();

    @OneToMany(mappedBy ="user")
    private List<Post> posts = new ArrayList<Post>();

}
