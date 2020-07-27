package io.github.mokaim.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestRestController {

    HashMap<String, String> hashMap = new HashMap<String, String>();

    @GetMapping("test")
    public HashMap<String, String> getJsonTest(){

        hashMap.put("test1", "kwon");
        hashMap.put("test2", "helloworld");

        return hashMap;

    }
}
