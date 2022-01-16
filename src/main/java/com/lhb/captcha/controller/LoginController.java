package com.lhb.captcha.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lhb
 * @date 2022/1/9 14:43
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, String verCode){
        if (!CaptchaUtil.ver(verCode, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return "验证码不正确";
        }
        return "验证码正确";
    }
}