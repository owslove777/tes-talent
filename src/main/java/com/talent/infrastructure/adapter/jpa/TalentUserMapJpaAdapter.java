package com.talent.infrastructure.adapter.jpa;

import com.talent.domain.data.TalentUserMapDto;
import com.talent.domain.ports.spi.TalentUserMapPersistencePort;
import com.talent.infrastructure.entity.TalentUserMap;
import com.talent.infrastructure.repository.TalentUserMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentUserMapJpaAdapter implements TalentUserMapPersistencePort {

    @Autowired
    private TalentUserMapRepository talentUserMapRepository;

    @Override
    public List<TalentUserMapDto> findAll() {
        List<TalentUserMap> list = talentUserMapRepository.findAll(Sort.by(Sort.Direction.ASC, "userId"));
        return TalentUserMap.toDtoList(list);
    }

    @Override
    public TalentUserMapDto findById(Long id) {
        Optional<TalentUserMap> byId = talentUserMapRepository.findById(id);
        return byId.map(TalentUserMap::toDto).orElse(null);
    }

    @Override
    public TalentUserMapDto save(TalentUserMapDto src) {
        TalentUserMap saved = talentUserMapRepository.save(TalentUserMap.parseFrom(src));
        return saved.toDto();
    }

    @Override
    public Boolean deleteById(Long id) {
        talentUserMapRepository.deleteById(id);
        return true;
    }

    @Override
    public List<TalentUserMapDto> findByCategoryId(Long id) {
        List<TalentUserMap> list = talentUserMapRepository.findByCategoryId(id);
        return TalentUserMap.toDtoList(list);
    }

    @Override
    public List<TalentUserMapDto> findByCategoryIdAndAddress(Long id, String address) {
        List<TalentUserMap> list = talentUserMapRepository.findByCategoryIdAndAddress(id, address);
        return TalentUserMap.toDtoList(list);
    }

    @Override
    public void deleteByCategoryId(Long id) {
        talentUserMapRepository.deleteByCategoryId(id);
    }
}
