package com.talent.domain.ports.api;

import com.talent.domain.data.TalentUserMapDto;
import com.talent.domain.ports.spi.TalentUserMapPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalentUserMapServiceImpl implements TalentUserMapServicePort{

    private final TalentUserMapPersistencePort talentUserMapPersistence;

    @Override
    public List<TalentUserMapDto> findAll() {
        return talentUserMapPersistence.findAll();
    }

    @Override
    public TalentUserMapDto findById(Long id) {
        return talentUserMapPersistence.findById(id);
    }

    @Override
    public TalentUserMapDto save(TalentUserMapDto src) {
        return talentUserMapPersistence.save(src);
    }

    @Override
    public Boolean deleteById(Long id) {
        return talentUserMapPersistence.deleteById(id);
    }

    @Override
    public List<TalentUserMapDto> findByCategoryId(Long id) {
        return talentUserMapPersistence.findByCategoryId(id);
    }

    @Override
    public List<TalentUserMapDto> findByCategoryIdAndAddress(Long id, String address) {
        return talentUserMapPersistence.findByCategoryIdAndAddress(id, address);
    }
}
