package cz.vsb.austra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class GreetingController {
    @GetMapping("/hello")
    String hello(){
        return "Hello world";
    }
    @GetMapping("/greeting")
    String greeting(){
        return "Čau vole";
    }
}
