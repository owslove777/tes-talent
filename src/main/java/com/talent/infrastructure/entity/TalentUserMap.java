package com.talent.infrastructure.entity;

import com.talent.domain.data.TalentUserMapDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "talent_user_map")
@Table(name = "talent_user_map",
		uniqueConstraints={@UniqueConstraint(columnNames = {"categoryId", "userId"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentUserMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	Long categoryId;

	@Column(nullable = false)
	Long userId;

	String title;

	String description;

	public static TalentUserMap parseFrom(TalentUserMapDto src) {
		return TalentUserMap.builder()
				.id(src.getId())
				.categoryId(src.getCategoryId())
				.userId(src.getUserId())
				.title(src.getTitle())
				.description(src.getDescription())
				.build();
	}

	public static List<TalentUserMapDto> toDtoList(List<TalentUserMap> list) {
		return list.stream().map(m -> m.toDto()).collect(Collectors.toList());
	}

	public TalentUserMapDto toDto() {
		return TalentUserMapDto.builder()
				.id(id)
				.categoryId(categoryId)
				.userId(userId)
				.title(title)
				.description(description)
				.build();
	}
}
