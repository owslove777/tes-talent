package com.talent.infrastructure.repository.querydsl;

import com.talent.infrastructure.entity.TalentEntity;

import java.util.List;

public interface TalentRepositoryCustom {
    List<TalentEntity> findByCategoryIdAndAddress(Long id, String address);
}
