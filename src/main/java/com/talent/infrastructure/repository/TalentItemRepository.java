package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentItemRepository extends JpaRepository<TalentItem, Long> {
    List<TalentItem> findByTalentId(Long id);

    void deleteByTalentId(Long categoryId);
}
