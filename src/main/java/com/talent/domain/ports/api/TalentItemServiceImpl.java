package com.talent.domain.ports.api;

import com.talent.domain.data.TalentItemDto;
import com.talent.domain.enums.TALENT_ITEM_STATUS;
import com.talent.domain.ports.spi.TalentItemPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalentItemServiceImpl implements TalentItemServicePort{

    private final TalentItemPersistencePort talentItemPersistence;

    @Override
    public List<TalentItemDto> findAll() {
        return talentItemPersistence.findAll();
    }

    @Override
    public TalentItemDto findById(Long id) {
        return talentItemPersistence.findById(id);
    }

    @Override
    public TalentItemDto save(TalentItemDto src) {
        return talentItemPersistence.save(src);
    }

    @Override
    public TalentItemDto updateStatus(Long itemId, TALENT_ITEM_STATUS status) {
        TalentItemDto dto = findById(itemId);
        if (dto == null) {
            return null;
        }
        dto.setStatus(status);
        return save(dto);
    }

    @Override
    public Boolean deleteById(Long id) {
        return talentItemPersistence.deleteById(id);
    }
}
