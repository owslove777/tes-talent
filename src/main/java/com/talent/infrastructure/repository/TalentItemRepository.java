package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentItemRepository extends JpaRepository<TalentItem, Long> {
}
