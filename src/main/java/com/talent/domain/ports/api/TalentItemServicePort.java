package com.talent.domain.ports.api;

import com.talent.domain.data.TalentItemDto;

import java.util.List;

public interface TalentItemServicePort {
    List<TalentItemDto> findAll();

    TalentItemDto findById(Long id);

    TalentItemDto save(TalentItemDto src);

    Boolean deleteById(Long id);
}
