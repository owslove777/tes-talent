package com.talent.domain.ports.api;

import com.talent.domain.data.TalentUserMapDto;

import java.util.List;

public interface TalentUserMapServicePort {
    List<TalentUserMapDto> findAll();

    TalentUserMapDto findById(Long id);

    TalentUserMapDto save(TalentUserMapDto src);

    Boolean deleteById(Long id);

    List<TalentUserMapDto> findByCategoryId(Long id);

    List<TalentUserMapDto> findByCategoryIdAndAddress(Long id, String address);
}
