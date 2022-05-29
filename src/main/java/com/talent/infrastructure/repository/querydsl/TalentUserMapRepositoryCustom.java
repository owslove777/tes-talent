package com.talent.infrastructure.repository.querydsl;

import com.talent.infrastructure.entity.TalentUserMap;

import java.util.List;

public interface TalentUserMapRepositoryCustom {
    List<TalentUserMap> findByCategoryIdAndAddress(Long id, String address);
}
