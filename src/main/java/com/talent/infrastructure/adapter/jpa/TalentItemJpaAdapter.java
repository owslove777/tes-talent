package com.talent.infrastructure.adapter.jpa;

import com.talent.domain.data.TalentItemDto;
import com.talent.domain.ports.spi.TalentItemPersistencePort;
import com.talent.infrastructure.entity.TalentItem;
import com.talent.infrastructure.repository.TalentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentItemJpaAdapter implements TalentItemPersistencePort {

    @Autowired
    private TalentItemRepository repository;

    @Override
    public List<TalentItemDto> findAll() {
        List<TalentItem> list = repository.findAll(Sort.by(Sort.Direction.ASC, "talent_id"));
        return TalentItem.toDtoList(list);
    }

    @Override
    public TalentItemDto findById(Long id) {
        Optional<TalentItem> byId = repository.findById(id);
        return byId.isPresent() ? byId.get().toDto() : null;
    }

    @Override
    public TalentItemDto save(TalentItemDto src) {
        TalentItem entity = TalentItem.parseFrom(src);
        TalentItem saved = repository.save(entity);
        return saved.toDto();
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
