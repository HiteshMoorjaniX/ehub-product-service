package com.ehub.productservice.module;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @GetMapping
    public String getModule(){
        return "Hello!";
    }
}