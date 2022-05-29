package com.talent.domain.ports.spi;

import com.talent.domain.data.TalentItemDto;

import java.util.List;

public interface TalentItemPersistencePort {
    List<TalentItemDto> findAll();

    TalentItemDto findById(Long id);

    TalentItemDto save(TalentItemDto src);

    Boolean deleteById(Long id);
}
