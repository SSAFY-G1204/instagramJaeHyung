package com.example.instagram_backend.domain.ContentManagement.dao;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Builder // 빌더 패턴
@Table(name = "medias")
public class Media {

    // @MapsId를 통해 Users 엔티티의 userId와 동일한 값이 설정됩니다.

    @Id
    @ManyToOne
    @MapsId
    @JoinColumn(name = "postId", nullable = false)  // 외래 키로 profiles 테이블에서 userId를 사용합니다.
    private Post post;

    @Column
    private String imageSrc;

}
