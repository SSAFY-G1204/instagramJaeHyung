package com.example.instagram_backend.domain.SocialRelations.service;

import com.example.instagram_backend.domain.SocialRelations.dao.Relation;
import com.example.instagram_backend.domain.SocialRelations.repository.RelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {

    private final RelationRepository relationRepository;

    public RelationService(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

    public List<Relation> findRelationByFollowerId(Long userId) {
        return relationRepository.findRelationByFollowerId(userId);
    }




}
