package ru.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.project.dto.CorporateSettlementInstance;
import ru.project.dto.ProductResponse;
import ru.project.service.ProductService;

@RestController()
@Validated
public class CorporateSettlementInstanceCreate {
    @Autowired
    ProductService productService;
    @PostMapping("/corporate-settlement-instance/create")
    ProductResponse handle(@Valid @RequestBody CorporateSettlementInstance csi){
        ProductResponse productResponse = productService.processCreateRequest(csi);

        return productResponse;
    }

}
