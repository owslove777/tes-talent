package com.talent.infrastructure.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.talent.infrastructure.entity.QTalentUserMap;
import com.talent.infrastructure.entity.TalentUserMap;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalentUserMapRepositoryCustomImpl implements TalentUserMapRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private QTalentUserMap userMap = QTalentUserMap.talentUserMap;

    @Override
    public List<TalentUserMap> findByCategoryIdAndAddress(Long id, String address) {
        return null;
    }
}
