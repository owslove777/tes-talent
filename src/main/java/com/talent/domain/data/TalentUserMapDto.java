package com.talent.domain.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TalentUserMapDto {

	Long id;
	Long categoryId;
	Long userId;
	String title;
	String description;

}
