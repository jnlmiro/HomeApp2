package com.jorgma.homeapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jorgma on 2017-12-10.
 */
@Configuration
public class CustomKeyRestTemplate {


    @Bean
    public RestTemplate stationsSearchRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
