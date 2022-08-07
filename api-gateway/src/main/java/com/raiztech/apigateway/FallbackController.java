package com.raiztech.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/projectFallBack")
    public Mono<String> projectServiceFallBack(){
        return Mono.just("Project Service is taking too long to respond or is down." +
                "Please try again later!");
    }

    @RequestMapping("/taskFallBack")
    public Mono<String> taskServiceFallBack(){
        return Mono.just("Task Service is taking too long to respond or is down." +
                "Please try again later!");
    }
}
