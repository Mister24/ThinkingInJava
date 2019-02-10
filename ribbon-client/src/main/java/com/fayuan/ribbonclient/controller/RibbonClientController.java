/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mr.24
 * @version Id: RibbonClientController, v 1.0 2019/2/8 下午6:59 Exp $$
 */
@RestController
public class RibbonClientController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    public String requestForHi(@RequestParam String name){
        return restTemplate.getForObject("http://ribbon-server/hi?name="+name,String.class);
    }
}
