package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

import javax.annotation.PostConstruct;

@Component
public class DemoService {

    private final Logbook logbook;

    public DemoService(Logbook logbook) {
        this.logbook = logbook;
    }

    @PostConstruct
    void demo() {
        LogbookClientHttpRequestInterceptor interceptor = new LogbookClientHttpRequestInterceptor(logbook);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(interceptor);

        restTemplate.getForEntity("https://example.com/", String.class);
    }

}
