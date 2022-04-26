package com.talent.domain;

import javax.persistence.*;

@Entity
public class Talent {

	String talentName;
	// Level level; //

	@Id
	@GeneratedValue
	Long talentId;

	public Long getTalentId() {
		return talentId;
	}

	public void setTalentId(Long talentId) {
		this.talentId = talentId;
	}

	public String getTalentName() {
		return talentName;
	}

	public void setTalentName(String talentName) {
		this.talentName = talentName;
	}

	// public Level getLevel() {
	// return level;
	// }

	// public void setLevel(Level level) {
	// this.level = level;
	// }

}
