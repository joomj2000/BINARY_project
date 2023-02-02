package com.hotdesking.study.web;

import com.hotdesking.study.domain.UserRequest;
import com.hotdesking.study.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String joinUs(UserRequest request){
        log.info("userId={}, password={}, userName={}",
                request.getUserId(), request.getPassword(), request.getUserName());
        userService.joinUser(request);
        if(userService.joinUser(request).equals("Success")) {
            return "index";
        }
        //return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest request){
        log.info("userId = {}, password = {}", request.getUserId(), request.getPassword());
        userService.login(request.getUserId(), request.getPassword());
        return "index";
    }
}
