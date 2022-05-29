package com.talent.application.controller;

import com.talent.domain.data.TalentCategoryDto;
import com.talent.domain.ports.api.TalentCategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final TalentCategoryServicePort talentService;

    /**
     * 전체 카테고리 조회
     * @return
     */
    @GetMapping("/category")
    public List<TalentCategoryDto> allCategories(){
        return talentService.findAll();
    }

    /**
     * id로 카테고리 조회
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public TalentCategoryDto findById(@PathVariable Long id){
        return talentService.findById(id);
    }

    /**
     * 신규 카테고리 생성
     * @param src
     * @return
     */
    @PostMapping("/category")
    public TalentCategoryDto createNewCategory(@RequestBody TalentCategoryDto src){
        return talentService.save(src);
    }

    /**
     * id로 카테고리 삭제 (하위에 속한 사용자의 매핑도 삭제함)
     * @param id
     * @return
     */
    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentService.deleteById(id);
    }
}
