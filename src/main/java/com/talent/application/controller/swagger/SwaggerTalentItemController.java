package com.talent.application.controller.swagger;

import com.talent.application.controller.TalentItemController;
import com.talent.domain.ports.api.TalentItemServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talent")
public class SwaggerTalentItemController extends TalentItemController {

    public SwaggerTalentItemController(TalentItemServicePort talentItemService) {
        super(talentItemService);
    }
}
