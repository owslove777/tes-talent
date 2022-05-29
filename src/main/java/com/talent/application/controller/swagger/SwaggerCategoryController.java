package com.talent.application.controller.swagger;

import com.talent.application.controller.CategoryController;
import com.talent.domain.data.TalentCategoryDto;
import com.talent.domain.ports.api.TalentCategoryServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talent")
//@Tag(name = "_swagger_#01_Category")
public class SwaggerCategoryController extends CategoryController {
    public SwaggerCategoryController(TalentCategoryServicePort talentService) {
        super(talentService);
    }
}
