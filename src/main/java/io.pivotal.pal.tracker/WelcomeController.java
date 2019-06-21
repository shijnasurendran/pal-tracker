package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    String message;

    public WelcomeController(@Value("${message}") String message)
    {
        this.message=message;
    }

    @GetMapping(value = "/")
    public String sayHello()
    {
        return message;
    }
}
