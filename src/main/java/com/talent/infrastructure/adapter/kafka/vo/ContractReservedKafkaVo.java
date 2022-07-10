package com.talent.infrastructure.adapter.kafka.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractReservedKafkaVo extends KafkaData {
    private ContractDto contractDto;
}