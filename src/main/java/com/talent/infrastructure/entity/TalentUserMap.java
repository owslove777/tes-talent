package com.talent.infrastructure.entity;

import com.talent.domain.data.TalentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "talent_master")
@Table(name = "talent_master",
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

	String address;

	String title;

	String description;

	public static TalentUserMap parseFrom(TalentDto src) {
		return TalentUserMap.builder()
				.id(src.getId())
				.categoryId(src.getCategoryId())
				.userId(src.getUserId())
				.address(src.getAddress())
				.title(src.getTitle())
				.description(src.getDescription())
				.build();
	}

	public static List<TalentDto> toDtoList(List<TalentUserMap> list) {
		return list.stream().map(m -> m.toDto()).collect(Collectors.toList());
	}

	public TalentDto toDto() {
		return TalentDto.builder()
				.id(id)
				.categoryId(categoryId)
				.userId(userId)
				.title(title)
				.description(description)
				.build();
	}
}
