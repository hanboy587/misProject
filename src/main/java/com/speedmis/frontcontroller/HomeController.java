package com.speedmis.frontcontroller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/main")
public class HomeController {

    @GetMapping("/testT")
    public String test() {
        return "aaa";
    }
    
}
