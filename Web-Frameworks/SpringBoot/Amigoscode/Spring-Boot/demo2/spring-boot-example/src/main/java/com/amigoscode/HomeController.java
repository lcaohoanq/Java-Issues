package com.amigoscode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index"; // This will return the index.html file under src/main/resources/static
    }
}