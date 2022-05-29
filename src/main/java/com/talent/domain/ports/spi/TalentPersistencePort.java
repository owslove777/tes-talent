package com.talent.domain.ports.spi;

import com.talent.domain.data.TalentDto;

import java.util.List;

public interface TalentPersistencePort {
    List<TalentDto> findAll();

    TalentDto findById(Long id);

    TalentDto save(TalentDto src);

    Boolean deleteById(Long id);

    List<TalentDto> findByCategoryId(Long id);

    List<TalentDto> findByCategoryIdAndAddress(Long id, String address);

    void deleteByCategoryId(Long id);
}
