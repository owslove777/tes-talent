package com.talent.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "talent_user_map")
@Table(name = "talent_user_map")
@Data
public class TalentUserMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long categoryId;
	Long userId;
	String title;
	String description;

}
