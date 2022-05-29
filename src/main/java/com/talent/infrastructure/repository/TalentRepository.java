package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentEntity;
import com.talent.infrastructure.repository.querydsl.TalentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentRepository extends JpaRepository<TalentEntity, Long>, TalentRepositoryCustom {
    List<TalentEntity> findByCategoryId(Long id);

    void deleteByCategoryId(Long id);
}
