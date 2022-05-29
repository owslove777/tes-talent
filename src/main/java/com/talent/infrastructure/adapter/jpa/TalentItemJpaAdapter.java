package com.talent.infrastructure.adapter.jpa;

import com.talent.domain.data.TalentItemDto;
import com.talent.domain.ports.spi.TalentItemPersistencePort;
import com.talent.infrastructure.entity.TalentItem;
import com.talent.infrastructure.repository.TalentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TalentItemJpaAdapter implements TalentItemPersistencePort {

    @Autowired
    private TalentItemRepository repository;

    @Override
    public List<TalentItemDto> findAll() {
        List<TalentItem> list = repository.findAll(Sort.by(Sort.Direction.ASC, "talentId"));
        return TalentItem.toDtoList(list);
    }

    @Override
    public TalentItemDto findById(Long id) {
        Optional<TalentItem> byId = repository.findById(id);
        return byId.map(TalentItem::toDto).orElse(null);
    }

    @Override
    public TalentItemDto save(TalentItemDto src) {
        TalentItem entity = TalentItem.parseFrom(src);
        TalentItem saved = repository.save(entity);
        return saved.toDto();
    }

    @Override
    @Transactional
    public List<TalentItemDto> saveAll(List<TalentItemDto> talentSelectOptions) {
        if (talentSelectOptions == null || talentSelectOptions.isEmpty()) {
            return new ArrayList<>();
        }

        for (TalentItemDto item: talentSelectOptions) {
            item.setId(null); // 자동 생성
        }

        List<TalentItem> entityList = talentSelectOptions.stream()
                .map(TalentItem::parseFrom)
                .collect(Collectors.toList());
        List<TalentItem> saved = repository.saveAll(entityList);
        return saved.stream().map(TalentItem::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TalentItemDto> findByTalentId(Long id) {
        List<TalentItem> list = repository.findByTalentId(id);
        return list.stream().map(TalentItem::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteByTalentId(Long talentId) {
        repository.deleteByTalentId(talentId);
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
