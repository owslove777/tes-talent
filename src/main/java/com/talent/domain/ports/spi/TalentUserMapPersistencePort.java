package com.talent.domain.ports.spi;

import com.talent.domain.data.TalentUserMapDto;

import java.util.List;

public interface TalentUserMapPersistencePort {
    List<TalentUserMapDto> findAll();

    TalentUserMapDto findById(Long id);

    TalentUserMapDto save(TalentUserMapDto src);

    Boolean deleteById(Long id);

    List<TalentUserMapDto> findByCategoryId(Long id);

    List<TalentUserMapDto> findByCategoryIdAndAddress(Long id, String address);

    void deleteByCategoryId(Long id);
}
