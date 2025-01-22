package com.mike.webapp;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/data")
    public String getData(@RequestParam(value = "orderId", required = false) String orderId) {

       if (StringUtils.hasText(orderId)) {
           return String.format("Success for %s", orderId);
       }
       return String.format("Order: %s doesn't exist", orderId);
    }
}
