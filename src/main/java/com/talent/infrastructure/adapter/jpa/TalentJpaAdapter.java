package com.talent.infrastructure.adapter.jpa;

import com.talent.domain.data.TalentDto;
import com.talent.domain.ports.spi.TalentPersistencePort;
import com.talent.infrastructure.entity.TalentEntity;
import com.talent.infrastructure.repository.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentJpaAdapter implements TalentPersistencePort {

    @Autowired
    private TalentRepository talentRepository;

    @Override
    public List<TalentDto> findAll() {
        List<TalentEntity> list = talentRepository.findAll(Sort.by(Sort.Direction.ASC, "userId"));
        return TalentEntity.toDtoList(list);
    }

    @Override
    public TalentDto findById(Long id) {
        Optional<TalentEntity> byId = talentRepository.findById(id);
        return byId.map(TalentEntity::toDto).orElse(null);
    }

    @Override
    public TalentDto save(TalentDto src) {
        TalentEntity saved = talentRepository.save(TalentEntity.parseFrom(src));
        return saved.toDto();
    }

    @Override
    public Boolean deleteById(Long id) {
        talentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<TalentDto> findByCategoryId(Long id) {
        List<TalentEntity> list = talentRepository.findByCategoryId(id);
        return TalentEntity.toDtoList(list);
    }

    @Override
    public List<TalentDto> findByCategoryIdAndAddress(Long id, String address) {
        List<TalentEntity> list = talentRepository.findByCategoryIdAndAddress(id, address);
        return TalentEntity.toDtoList(list);
    }

    @Override
    public void deleteByCategoryId(Long id) {
        talentRepository.deleteByCategoryId(id);
    }
}
