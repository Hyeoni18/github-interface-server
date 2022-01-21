package com.gitface.server.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/handler")
    public Map<Object,Object> handler(@RequestBody Map<Object, Object> data){
        data.put("res", "OK");

        logger.info("######## Webhooks payload ########");
        logger.info(data.toString());

        return data;
    }
}
