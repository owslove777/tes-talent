package com.talent.application.controller;

import com.talent.domain.data.TalentDto;
import com.talent.domain.ports.api.TalentServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TalentController {

    private final TalentServicePort talentUserMapService;

    /**
     * 카테고리와 사용자의 매핑관계 전체 조회
     * @return
     */
    @GetMapping("/talents")
    public List<TalentDto> allMappings(){
        return talentUserMapService.findAll();
    }

    /**
     * id로 매핑 조회
     * @param id
     * @return
     */
    @GetMapping("/talents/{id}")
    public TalentDto findById(@PathVariable Long id){
        return talentUserMapService.findById(id);
    }

    /**
     * category id로 매핑 관계 조회
     * @param id
     * @param address
     * @return
     */
    @GetMapping("/talents/category/{id}")
    public List<TalentDto> findByCategoryId(@PathVariable Long id,
                                            @RequestParam(required = false) String address){
        if (Strings.isEmpty(address)) {
            return talentUserMapService.findByCategoryId(id);
        }
        return talentUserMapService.findByCategoryIdAndAddress(id, address);
    }

    /**
     * 신규 매핑 생성
     * @param src
     * @return
     */
    @PostMapping("/talents")
    public TalentDto createNewCategoryUserMap(@RequestBody TalentDto src){
        return talentUserMapService.save(src);
    }

    /**
     * 매핑 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/talents/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentUserMapService.deleteById(id);
    }
}
