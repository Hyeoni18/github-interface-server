package com.gitface.server.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gitface.server.utils.RestApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
* @author : hanum
* @date   : 2022-01-22
* @desc   : 기능 테스트를 위한 컨트롤러
**/

@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Webhooks 테스트
    @PostMapping("/handler")
    public Map<Object,Object> handler(@RequestBody Map<Object, Object> data){
        data.put("res", "OK");

        logger.info("######## Webhooks payload ########");
        logger.info(data.toString());

        return data;
    }

    // REST API 요청 테스트
    @GetMapping("/reqapi")
    public Map<Object, Object> reqApi(){
        RestApiRequest restApiRequest = new RestApiRequest();
        Map<Object, Object> res = new HashMap<>();

        try {
            // https://httpbin.org/get : 테스트 용도의 REST API URL
            String url = "https://httpbin.org/get";
            res = restApiRequest.requestByGetMethod(null, url);
        } catch (JsonProcessingException e) {
            res.put("res", "failed");
            res.put("msg", e.getMessage());
        }

        return res;
    }

}
