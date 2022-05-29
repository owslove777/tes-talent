package com.talent.infrastructure.repository.querydsl;

import com.talent.infrastructure.entity.TalentUserMap;

import java.util.List;

public interface TalentRepositoryCustom {
    List<TalentUserMap> findByCategoryIdAndAddress(Long id, String address);
}
