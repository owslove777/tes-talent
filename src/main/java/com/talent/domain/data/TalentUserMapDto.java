package com.talent.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentUserMapDto {

	Long id;
	Long categoryId;
	Long userId;
	String title;
	String description;

}
