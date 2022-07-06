package com.talent.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentDto {

	Long id;
	Long categoryId;
	Long userId;
	String userName;
	String address;
	String title;
	String description;

	List<TalentItemDto> options;

}
