package com.hotdesking.study.service;

import com.hotdesking.study.domain.User;
import com.hotdesking.study.domain.UserRequest;
import com.hotdesking.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    //@Autowired
    private final UserRepository userRepository;

    public String joinUser(UserRequest request){
        //vo.setRole("USER");
        userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .userName(request.getUserName())
                .build());
        return "Success";
    }

    public String login(String userId, String password){
        Optional<User> user=userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}", user.get().getPassword(), password);
        if(user.get().getPassword().equals(password)) {
            return "Success";
        }
        return "Failed";
    }
}
