package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    String message;
    String sentence;

    public WelcomeController(@Value("${welcome.message}") String message,
                   @Value("${sentence}") String sentence)
    {
        this.message=message;
        this.sentence=sentence;
    }

    @GetMapping(value="/")
    public String hello()
    {
        return message;
    }
    @GetMapping(value="/sentence")
    public String sentence()
    {
        return sentence;
    }
}
