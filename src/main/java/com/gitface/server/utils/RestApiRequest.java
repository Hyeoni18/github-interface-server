package com.gitface.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
* @author : hanum
* @date   : 2022-01-25
* @desc   : REST API 요청 클래스
**/

public class RestApiRequest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map<Object, Object> requestByGetMethod(HttpHeaders headers, String url) throws JsonProcessingException {
        HttpEntity<String> entity = new HttpEntity<>("",headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        logger.info("##### REST API RESULT #####");
        logger.info(respEntity.getBody());



        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory factory = TypeFactory.defaultInstance();
        MapType type = factory.constructMapType(HashMap.class, Object.class, Object.class);

        Map<Object, Object> res = objectMapper.readValue(respEntity.getBody(), type);

        logger.info("##### PARSING #####");
        logger.info(res.toString());

        return res;
    }
}
