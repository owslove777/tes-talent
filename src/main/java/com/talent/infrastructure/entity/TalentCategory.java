package com.talent.infrastructure.entity;

import com.talent.domain.data.TalentCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "talent_category")
@Table(name = "talent_category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long talentId;

	String categoryName;

	public static TalentCategory parseFrom(TalentCategoryDto src) {
		return TalentCategory.builder()
				.talentId(src.getTalentId())
				.categoryName(src.getCategoryName())
				.build();
	}

	public static List<TalentCategoryDto> toDtoList(List<TalentCategory> list) {
		return list.stream().map(c -> c.toDto()).collect(Collectors.toList());
	}

	public TalentCategoryDto toDto() {
		TalentCategoryDto dto = new TalentCategoryDto();
		dto.setTalentId(talentId);
		dto.setCategoryName(categoryName);
		return dto;
	}
}
