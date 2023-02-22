package com.hotdesking.study.web;

import com.hotdesking.study.domain.*;
import com.hotdesking.study.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller//@RestController
@RequiredArgsConstructor
//@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private String tableId;
    private User user;
    @PostMapping("/user/signup")
    public String joinUs(UserRequest request){
        log.info("userId={}, password={}, userName={}",
                request.getUserId(), request.getPassword(), request.getUserName());
        //userService.joinUser(request);
        if(userService.joinUser(request).equals("Success")) {
            return "redirect:/home";
        }

        //return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return "Fail";
    }

    @PostMapping("/user/choose")
    public String choose(TableRequest tableRequest){
        log.info("tableId = {}", tableRequest.getTableId());
        tableId = tableRequest.getTableId();
        return "redirect:/home";
    }
    @PostMapping("/user/login")
    public String login(UserLogin request){
        log.info("userId = {}, password = {}", request.getUserId(), request.getPassword());
        log.info("tableId = {}", tableId);
        if(userService.login(request, tableId).equals("Success")) {
            return "redirect:/home";
        }
        return "Fail";
    }

//    @GetMapping("/find")
//    public void findGET(HttpSession session, Model model) throws Exception{
//        // 세션 객체 안에 있는 ID정보 저장
//        String name = (String) session.getAttribute("userName");
//        log.info("C: 회원정보보기 GET의 이름" + name);
//
//        // 서비스 안의 회원정보보기 메서드 호출
//
//    }
    @PostMapping("/user/find")
    public String find(UserFind request){
        log.info("userName = {}", request.getUserName());
        user = userService.findUser(request);

        return "redirect:/findInfo";
    }

//    @GetMapping("/findInfo")
//    public RedirectView addFindUser(Model model){
//        model.addAttribute("user", user);
//        return new RedirectView("/userInfo");
//    }
    @GetMapping("/findInfo")
    public String addFindUser(Model model){
        model.addAttribute("user", user);
        return "userInfo";
    }

//    @GetMapping("/userInfo")
//    public String userInfo(){return "userInfo";}
}
