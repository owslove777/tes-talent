package com.talent.infrastructure.adapter.kafka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;

//의뢰서는 buyerId, talentId, talent의 level 정보를 갖고있다.
//@Entity
public class RequestReserved extends AbstractEvent {

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

	@PostPersist
	public void onPostPersist() {
		RequestReserved requestReserved = new RequestReserved();

	}

}
