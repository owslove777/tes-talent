package com.talent.domain.ports.api;

import com.talent.domain.data.TalentDto;
import com.talent.domain.data.TalentItemDto;
import com.talent.domain.ports.spi.TalentItemPersistencePort;
import com.talent.domain.ports.spi.TalentPersistencePort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class TalentServiceImpl implements TalentServicePort {

    private final TalentPersistencePort talentPersistence;
    private final TalentItemPersistencePort talentItemPersistence;

    @Override
    public List<TalentDto> findAll() {
        return talentPersistence.findAll();
    }

    @Override
    public TalentDto findById(Long id) {
        return talentPersistence.findById(id);
    }

    @Override
    public TalentDto findByIdWithOptions(Long id) {
        TalentDto byId = findById(id);
        byId.setOptions(talentItemPersistence.findByTalentId(id));
        return byId;
    }

    @Override
    @Transactional
    public TalentDto save(TalentDto src) {
        TalentDto saved = talentPersistence.save(src);
        List<TalentItemDto> talentSelectOptions = src.getOptions();
        talentSelectOptions.forEach(o -> o.setTalentId(saved.getId()));
        talentItemPersistence.saveAll(talentSelectOptions);
        return saved;
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        talentItemPersistence.deleteByTalentId(id);
        return talentPersistence.deleteById(id);
    }

    @Override
    public List<TalentDto> findByCategoryId(Long id) {
        return talentPersistence.findByCategoryId(id);
    }

    @Override
    public List<TalentDto> findByCategoryIdAndAddress(Long id, String address) {
        return talentPersistence.findByCategoryIdAndAddress(id, address);
    }

    @Override
    public List<TalentDto> findByUserId(Long userId) {
        return talentPersistence.findByUserId(userId);
    }
}
