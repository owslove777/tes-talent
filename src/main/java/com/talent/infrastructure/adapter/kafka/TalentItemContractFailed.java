package com.talent.infrastructure.adapter.kafka;

import com.talent.infrastructure.adapter.kafka.vo.ContractDto;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TalentItemContractFailed extends AbstractEvent {
	private ContractDto contractDto;
}
