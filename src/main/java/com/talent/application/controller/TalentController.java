package com.talent.application.controller;

import com.talent.domain.data.TalentDto;
import com.talent.domain.ports.api.TalentServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class TalentController {

    private final TalentServicePort talentService;

    /**
     * 카테고리와 사용자의 매핑관계 전체 조회
     * @return
     */
    @GetMapping("/talents")
    public List<TalentDto> allMappings(){
        return talentService.findAll();
    }

    /**
     * id로 talent 조회
     * @param id
     * @return
     */
    @GetMapping("/talents/{id}")
    public TalentDto findById(@PathVariable Long id){
        return talentService.findById(id);
    }

    @GetMapping("/talents/detail/{id}")
    public TalentDto findByIdWithOptions(@PathVariable Long id){
        return talentService.findByIdWithOptions(id);
    }

    /**
     * category id로 매핑 관계 조회
     * @param id
     * @param address
     * @return
     */
    @GetMapping("/talents/category/{id}") @Operation(summary = "카테고리로 판매 재능 조회, 주소는 옵션")
    public List<TalentDto> findByCategoryId(@PathVariable Long id,
                                            @RequestParam(required = false) String address){
        if (Strings.isEmpty(address)) {
            return talentService.findByCategoryId(id);
        }
        return talentService.findByCategoryIdAndAddress(id, address);
    }

    /**
     * category id로 매핑 관계 조회
     * @param id
     * @param address
     * @return
     */
    @GetMapping("/talents/user/{id}") @Operation(summary = "사용자 ID로 판매 재능 조회")
    public List<TalentDto> findByUserId(@PathVariable Long id){
        return talentService.findByUserId(id);
    }

    /**
     * 신규 재능 생성
     * @param src
     * @return
     */
    @PostMapping("/talents")
    public TalentDto createNewCategoryUserMap(@RequestBody TalentDto src){
        src.setId(null); // 자동 생성
        return talentService.save(src);
    }

    /**
     * 재능 삭제, 하위 옵션도 함께 삭제됨
     * @param id
     * @return
     */
    @DeleteMapping("/talents/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentService.deleteById(id);
    }
}
