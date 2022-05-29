package com.talent.infrastructure.repository.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.talent.infrastructure.entity.QTalentEntity;
import com.talent.infrastructure.entity.TalentEntity;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

@RequiredArgsConstructor
public class TalentRepositoryCustomImpl implements TalentRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QTalentEntity talent = QTalentEntity.talentEntity;

    @Override
    public List<TalentEntity> findByCategoryIdAndAddress(Long id, String address) {
        JPAQuery<TalentEntity> query = queryFactory
                .selectFrom(talent)
                .where(talent.id.eq(id));
        if (Strings.isNotEmpty(address)) {
            query = query.where(talent.address.eq(address));
        }
        query.orderBy(talent.id.asc());

        return query.fetch();
    }
}
