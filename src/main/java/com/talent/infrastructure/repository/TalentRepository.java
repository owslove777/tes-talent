package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentUserMap;
import com.talent.infrastructure.repository.querydsl.TalentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentRepository extends JpaRepository<TalentUserMap, Long>, TalentRepositoryCustom {
    List<TalentUserMap> findByCategoryId(Long id);

    void deleteByCategoryId(Long id);
}
