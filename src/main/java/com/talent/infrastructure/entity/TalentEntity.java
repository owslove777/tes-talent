package com.talent.infrastructure.entity;

import com.talent.domain.data.TalentDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "talent_master")
@Table(name = "talent_master")
// uniqueConstraints={@UniqueConstraint(columnNames = {"categoryId", "userId"})}
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	Long categoryId;

	@Column(nullable = false)
	Long userId;

	String userName;

	String address;

	String title;

	String description;

	public static TalentEntity parseFrom(TalentDto src) {
		return TalentEntity.builder()
				.id(src.getId())
				.categoryId(src.getCategoryId())
				.userId(src.getUserId())
				.userName(src.getUserName())
				.address(src.getAddress())
				.title(src.getTitle())
				.description(src.getDescription())
				.build();
	}

	public static List<TalentDto> toDtoList(List<TalentEntity> list) {
		return list.stream().map(TalentEntity::toDto).collect(Collectors.toList());
	}

	public TalentDto toDto() {
		return TalentDto.builder()
				.id(id)
				.categoryId(categoryId)
				.userId(userId)
				.userName(userName)
				.title(title)
				.description(description)
				.address(address)
				.build();
	}
}
