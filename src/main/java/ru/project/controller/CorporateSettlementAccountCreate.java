package ru.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.project.dto.CorporateSettlementAccount;
import ru.project.dto.RegisterResponse;
import ru.project.service.RegisterService;

@RestController()
@Validated
public class CorporateSettlementAccountCreate {

    @Autowired
    RegisterService registerService;

    @PostMapping("/corporate-settlement-account/create")
    RegisterResponse handle(@Valid @RequestBody CorporateSettlementAccount csa){
        RegisterResponse registerResponse = registerService.processRequest(csa);

        return registerResponse;
    }


}
