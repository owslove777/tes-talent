package com.talent.domain.ports.spi;

import com.talent.domain.data.TalentCategoryDto;
import com.talent.infrastructure.entity.TalentCategory;

import java.util.List;

public interface TalentCategoryPersistencePort {
    TalentCategoryDto save(TalentCategory entity);

    Boolean deleteById(Long id);

    List<TalentCategoryDto> findAll();

    TalentCategoryDto findById(Long id);
}
