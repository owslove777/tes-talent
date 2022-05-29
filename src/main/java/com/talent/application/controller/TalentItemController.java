package com.talent.application.controller;

import com.talent.domain.data.TalentItemDto;
import com.talent.domain.ports.api.TalentItemServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TalentItemController {

    private final TalentItemServicePort talentItemService;

    /**
     * 전체 옵션 조회 (실제 사용 X, 확인용)
     * @return
     */
    @GetMapping("/talent-options")
    public List<TalentItemDto> allOptions(){
        return talentItemService.findAll();
    }

    /**
     * ID로 옵션 조회
     * @param id
     * @return
     */
    @GetMapping("/talent-options/{id}")
    public TalentItemDto findById(@PathVariable Long id){
        return talentItemService.findById(id);
    }

    /**
     * 신규 옵션 생성
     * @param src
     * @return
     */
    @PostMapping("/talent-options")
    public TalentItemDto createNewOption(@RequestBody TalentItemDto src){
        return talentItemService.save(src);
    }

    /**
     * 매핑 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/talent-options/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentItemService.deleteById(id);
    }
}
