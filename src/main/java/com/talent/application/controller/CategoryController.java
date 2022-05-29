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

    @GetMapping("/category")
    public List<TalentCategoryDto> allCategories(){
        return talentService.findAll();
    }

    @GetMapping("/category/{id}")
    public TalentCategoryDto findById(@PathVariable Long id){
        return talentService.findById(id);
    }

    @PostMapping("/category")
    public TalentCategoryDto createNewCategory(@RequestBody TalentCategoryDto src){
        return talentService.save(src);
    }

    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentService.deleteById(id);
    }
}
