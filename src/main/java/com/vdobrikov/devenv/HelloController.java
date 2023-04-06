package com.vdobrikov.devenv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final String UNKNOWN = "unknown";

    @GetMapping("/hello")
    public HelloDto hello(@RequestParam(required = false) final String name) {
        String actualName = name == null ? UNKNOWN : name;
        return new HelloDto("Hello " + actualName);
    }
}
