package com.talent.domain.ports.api;

import com.talent.domain.data.TalentItemDto;
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
    public Boolean deleteById(Long id) {
        return talentItemPersistence.deleteById(id);
    }
}
