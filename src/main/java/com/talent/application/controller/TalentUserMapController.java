package com.talent.application.controller;

import com.talent.domain.data.TalentUserMapDto;
import com.talent.domain.ports.api.TalentUserMapServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TalentUserMapController {

    private final TalentUserMapServicePort talentUserMapService;

    @GetMapping("/talent-user")
    public List<TalentUserMapDto> allMappings(){
        return talentUserMapService.findAll();
    }

    @GetMapping("/talent-user/{id}")
    public TalentUserMapDto findById(@PathVariable Long id){
        return talentUserMapService.findById(id);
    }

    @GetMapping("/talent-user/category/{id}")
    public List<TalentUserMapDto> findByCategoryId(@PathVariable Long id,
                                                   @RequestParam(required = false) String address){
        if (Strings.isEmpty(address)) {
            return talentUserMapService.findByCategoryId(id);
        }
        return talentUserMapService.findByCategoryIdAndAddress(id, address);
    }

    @PostMapping("/talent-user")
    public TalentUserMapDto createNewCategoryUserMap(@RequestBody TalentUserMapDto src){
        return talentUserMapService.save(src);
    }

    @DeleteMapping("/talent-user/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return talentUserMapService.deleteById(id);
    }
}
