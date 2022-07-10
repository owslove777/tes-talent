package com.talent.domain.ports.api;

import com.talent.domain.data.TalentItemDto;
import com.talent.domain.enums.TALENT_ITEM_STATUS;

import java.util.List;

public interface TalentItemServicePort {
    List<TalentItemDto> findAll();

    TalentItemDto findById(Long id);

    TalentItemDto save(TalentItemDto src);

    TalentItemDto updateStatus(Long itemId, TALENT_ITEM_STATUS status);

    Boolean deleteById(Long id);
}
