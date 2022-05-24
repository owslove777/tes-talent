package com.talent.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "talent_category")
@Table(name = "talent_category")
@Data
public class TalentCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long talentId;

	String categoryName;

}
