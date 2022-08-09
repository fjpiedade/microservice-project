package com.raiztech.apigateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/projectFallBack")
    @HystrixCommand(fallbackMethod = "taskServiceFallBack")
    public Mono<String> projectServiceFallBack(){
        return Mono.just("Project Service is taking too long to respond or is down." +
                "Please try again later!");
    }

    //@HystrixCommand(fallbackMethod="unknown")
    @HystrixCommand(fallbackMethod = "projectServiceFallBack")
    @RequestMapping("/taskFallBack")
    public Mono<String> taskServiceFallBack(){
        return Mono.just("Task Service is taking too long to respond or is down." +
                "Please try again later!");
    }


    public String unknown() {
        System.out.println("~~~~~~~~~");
        return "unknown";
    }
}
