package com.talent.domain.ports.api;

import com.talent.domain.data.TalentCategoryDto;

import java.util.List;

public interface TalentCategoryServicePort {
    TalentCategoryDto save(TalentCategoryDto src);

    Boolean deleteById(Long id);

    List<TalentCategoryDto> findAll();

    TalentCategoryDto findById(Long id);
}
