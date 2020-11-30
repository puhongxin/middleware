package com.debug.middleware.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xiaopu
 * @date: 2020-11-29 18:40
 */
@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        return "123";
    }
}
