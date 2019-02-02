package com.explore.gateway.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 错误执行器
 * @Author stanley.yu
 * @Date 2019/2/2 11:12
 */
@RestController
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }
}
