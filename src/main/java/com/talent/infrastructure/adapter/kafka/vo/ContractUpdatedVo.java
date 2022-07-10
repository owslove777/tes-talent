package com.talent.infrastructure.adapter.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractUpdatedVo extends KafkaData {
    private ContractDto contractDto;
}
