package com.talent.domain.ports.api;

import com.talent.domain.data.TalentDto;
import com.talent.domain.ports.spi.TalentPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalentServiceImpl implements TalentServicePort {

    private final TalentPersistencePort talentUserMapPersistence;

    @Override
    public List<TalentDto> findAll() {
        return talentUserMapPersistence.findAll();
    }

    @Override
    public TalentDto findById(Long id) {
        return talentUserMapPersistence.findById(id);
    }

    @Override
    public TalentDto save(TalentDto src) {
        return talentUserMapPersistence.save(src);
    }

    @Override
    public Boolean deleteById(Long id) {
        return talentUserMapPersistence.deleteById(id);
    }

    @Override
    public List<TalentDto> findByCategoryId(Long id) {
        return talentUserMapPersistence.findByCategoryId(id);
    }

    @Override
    public List<TalentDto> findByCategoryIdAndAddress(Long id, String address) {
        return talentUserMapPersistence.findByCategoryIdAndAddress(id, address);
    }
}
