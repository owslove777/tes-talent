package com.talent.infrastructure.repository;

import com.talent.infrastructure.entity.TalentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentCategoryRepository extends JpaRepository<TalentCategory, Long> {

}
