package com.dhruvdugar.APIGateway.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/eventServiceFallBack")
    public String eventServiceFallback(){
        return "event service is down";
    }

    @GetMapping("/venueServiceFallBack")
    public String venueServiceFallback(){
        return "venue service is down";
    }
}
