package com.talent.infrastructure.adapter.jpa;

import com.talent.domain.data.TalentCategoryDto;
import com.talent.domain.ports.spi.TalentCategoryPersistencePort;
import com.talent.infrastructure.entity.TalentCategory;
import com.talent.infrastructure.repository.TalentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentCategoryJpaAdapter implements TalentCategoryPersistencePort {
    @Autowired
    private TalentCategoryRepository repository;

    @Override
    public TalentCategoryDto save(TalentCategory entity) {
        TalentCategory saved = repository.save(entity);
        return saved.toDto();
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<TalentCategoryDto> findAll() {
        List<TalentCategory> list = repository.findAll(Sort.by(Sort.Direction.ASC, "categoryName"));
        return TalentCategory.toDtoList(list);
    }

    @Override
    public TalentCategoryDto findById(Long id) {
        Optional<TalentCategory> byId = repository.findById(id);
        return byId.isPresent() ? byId.get().toDto() : null;
    }
}
