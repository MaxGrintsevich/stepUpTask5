package ru.project.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.project.dto.CorporateSettlementAccount;
import ru.project.dto.RegisterResponse;

@RestController()
public class Index {
    @GetMapping("/index")
    String handle(String text){


        return "Hello World!";
    }
}
