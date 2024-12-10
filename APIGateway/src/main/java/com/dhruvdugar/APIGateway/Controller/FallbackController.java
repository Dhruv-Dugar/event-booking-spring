package com.dhruvdugar.APIGateway.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/eventServiceFallback")
    public String eventServiceFallback(){
        return "event service is down";
    }

    @GetMapping("/venueServiceFallback")
    public String venueServiceFallback(){
        return "venue service is down";
    }
}
