package com.talent.application.controller.swagger;

import com.talent.application.controller.TalentController;
import com.talent.domain.ports.api.TalentServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talent")
//@Tag(name = "_swagger_#02_Talent")
public class SwaggerTalentController extends TalentController {

    public SwaggerTalentController(TalentServicePort talentService) {
        super(talentService);
    }
}
