package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentUserMap;
import com.talent.infrastructure.repository.querydsl.TalentUserMapRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentUserMapRepository extends JpaRepository<TalentUserMap, Long>, TalentUserMapRepositoryCustom {
    List<TalentUserMap> findByCategoryId(Long id);

    void deleteByCategoryId(Long id);
}
