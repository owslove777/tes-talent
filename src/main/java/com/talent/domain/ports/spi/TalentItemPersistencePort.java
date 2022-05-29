package com.talent.domain.ports.spi;

import com.talent.domain.data.TalentItemDto;

import java.util.List;

public interface TalentItemPersistencePort {
    List<TalentItemDto> findAll();

    TalentItemDto findById(Long id);

    Boolean deleteById(Long id);

    TalentItemDto save(TalentItemDto src);

    List<TalentItemDto> saveAll(List<TalentItemDto> talentSelectOptions);

    List<TalentItemDto> findByTalentId(Long id);

    void deleteByTalentId(Long id);
}
