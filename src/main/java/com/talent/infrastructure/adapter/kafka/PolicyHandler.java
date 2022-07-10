package com.talent.infrastructure.adapter.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talent.domain.enums.TALENT_ITEM_STATUS;
import com.talent.domain.ports.api.TalentItemServicePort;
import com.talent.infrastructure.adapter.kafka.vo.ContractReservedKafkaVo;
import com.talent.infrastructure.adapter.kafka.vo.ContractUpdatedVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyHandler {

    private final TalentItemServicePort talentItemService;
    ObjectMapper mapper = new ObjectMapper();

    // 카프카 이슈 해결 완료
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){
        Map<String, String> map = parseToMap(eventString);
        if (map == null) {
            return;
        }

        switch (map.get("eventType")) {
//            case "UserCreated": // 신규 사용자 생성 시
//                log.info("## 신규 사용자 생성 이벤트 발생");
//                break;
            case "ContractReservedKafka": // 신규 계약 요청 시
                // ACCEPT_REQUESTED, ACCEPTED, PAID, REJECTED, PERFORMED, CANCELED
                log.info("## 신규 계약 요청 이벤트 발생");
                ContractReservedKafkaVo voReserved = parseToClass(eventString, ContractReservedKafkaVo.class);
                log.info("### ITEM ID ### " + voReserved.getContractDto().getTalentItemId());
                log.info("### ITEM STATUS ### " + voReserved.getContractDto().getContractStatus());
                talentItemService.updateStatus(voReserved.getContractDto().getTalentItemId(), TALENT_ITEM_STATUS.SOLD_OUT);
                // 재능인 정보에 신규 계약건 추가 (userRequestCntTotal++)
                // 요청자 정보에 신규 계약건 추가 (myRequestCntTotal++)
                break;
            case "ContractUpdated": // 계약 상태 업데이트 시
                log.info("## 계약 상태 업데이트 발생");
                ContractUpdatedVo voUpdated = parseToClass(eventString, ContractUpdatedVo.class);
                log.info("### ITEM ID ### " + voUpdated.getContractDto().getTalentItemId());
                log.info("### ITEM STATUS ### " + voUpdated.getContractDto().getContractStatus());
                if ("CANCELED".equals(voUpdated.getContractDto().getContractStatus()) || "REJECTED".equals(voUpdated.getContractDto().getContractStatus())){
                    talentItemService.updateStatus(voUpdated.getContractDto().getTalentItemId(), TALENT_ITEM_STATUS.ON_SALE);
                }
                break;
//            case "SettlementCreated":
//                log.info("## 신규 정산 대상 발생");
//                break;
//            case "SettlementUpdated":
//                log.info("## 정산 상태 업데이트 발생");
//                break;
//            case "StarRateCreated": // 별점 등록 시
//                log.info("## 신규 별점 등록 발생");
//                break;
            default:
                break;
        }
    }

    private <T> T parseToClass(String eventString, Class<T> clazz) {
        try {
            return mapper.readValue(eventString, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, String> parseToMap(String eventString) {
        Map<String, String> map = null;
        try {
            map = mapper.readValue(eventString, Map.class);
        } catch (JsonProcessingException e) {
            log.error(e.toString());
        }
        return map;
    }

}