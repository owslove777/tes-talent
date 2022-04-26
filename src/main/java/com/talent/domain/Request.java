package com.talent.domain;

import javax.persistence.*;

//의뢰서는 buyerId, talentId, talent의 level 정보를 갖고있다.
@Entity
public class Request {

	@Id
	@GeneratedValue
	Long requestId;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	Long talentId;

	public Long getTalentId() {
		return talentId;
	}

	public void setTalentId(Long talentId) {
		this.talentId = talentId;
	}

	Long buyerId; // User의 id

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	Level level;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@PostPersist
	public void onPostPersist() {
		RequestReserved requestReserved = new RequestReserved();
		requestReserved.setRequestId(this.requestId);
		requestReserved.setBuyerId(this.buyerId);
		requestReserved.setTalentId(this.talentId);
		requestReserved.setLevel(this.level);

		requestReserved.publishAfterCommit();
	}

	@Override
	public String toString() {

		return "<a href='./" + this.getClass().getSimpleName().toLowerCase() + "'" + ">"
				+ this.getClass().getSimpleName() + "</a>";
	}

}
