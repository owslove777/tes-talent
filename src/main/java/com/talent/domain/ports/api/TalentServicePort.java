package com.talent.domain.ports.api;

import com.talent.domain.data.TalentDto;

import java.util.List;

public interface TalentServicePort {
    List<TalentDto> findAll();

    TalentDto findById(Long id);

    TalentDto findByIdWithOptions(Long id);

    TalentDto save(TalentDto src);

    Boolean deleteById(Long id);

    List<TalentDto> findByCategoryId(Long id);

    List<TalentDto> findByCategoryIdAndAddress(Long id, String address);
}
