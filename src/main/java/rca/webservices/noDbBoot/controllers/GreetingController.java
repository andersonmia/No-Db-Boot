package rca.webservices.noDbBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rca.webservices.noDbBoot.services.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    private final AtomicLong counter = new AtomicLong(0);
    String content;
    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Sweetie")String name, @RequestParam(value = "time", defaultValue = "m") char timeOfDay){
        System.out.println("working..");
        switch (timeOfDay) {
            case 'm' -> {
                content = "Good morning " + name;
                return new Greeting(counter.incrementAndGet(), content);
            }
            case 'a' -> {
                content = "Good afternoon " + name;
                return new Greeting(counter.incrementAndGet(), content);
            }
            case 'e' -> {
                content = "Good evening " + name;
                return new Greeting(counter.incrementAndGet(), content);
            }
            default -> {
                content = "Hello "+name;
                return new Greeting(counter.incrementAndGet(),content);
            }
        }

    }
}
