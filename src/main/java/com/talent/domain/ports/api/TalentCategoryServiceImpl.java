package com.talent.domain.ports.api;

import com.talent.domain.data.TalentCategoryDto;
import com.talent.domain.ports.spi.TalentCategoryPersistencePort;
import com.talent.domain.ports.spi.TalentUserMapPersistencePort;
import com.talent.infrastructure.entity.TalentCategory;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class TalentCategoryServiceImpl implements TalentCategoryServicePort {

    private final TalentCategoryPersistencePort categoryPersistencePort;
    private final TalentUserMapPersistencePort talentUserMapPersistencePort;

    @Override
    public TalentCategoryDto save(TalentCategoryDto src) {
        TalentCategory entity = TalentCategory.parseFrom(src);
        entity.setTalentId(null); // 자동 주입
        return categoryPersistencePort.save(entity);
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        talentUserMapPersistencePort.deleteByCategoryId(id); // 해당 카테고리가 삭제되면, 관련된 재능인 연관관계도 삭제됨
        return categoryPersistencePort.deleteById(id);
    }

    @Override
    public List<TalentCategoryDto> findAll() {
        return categoryPersistencePort.findAll();
    }

    @Override
    public TalentCategoryDto findById(Long id) {
        return categoryPersistencePort.findById(id);
    }
}
