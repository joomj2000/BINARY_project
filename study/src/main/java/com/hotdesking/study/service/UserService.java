package com.hotdesking.study.service;

import com.hotdesking.study.domain.*;
import com.hotdesking.study.repository.TableRepository;
import com.hotdesking.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TableRepository tableRepository;

    public String joinUser(UserRequest request){
        //vo.setRole("USER");
        System.out.println("joinUser 실행");
        User user = new User();
        user.setUserId(request.getUserId());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName());
        userRepository.save(user);
//        userRepository.save(User.builder()
//                .userId(request.getUserId())
//                .password(request.getPassword())
//                .userName(request.getUserName())
//                .build());
        return "Success";
    }

    public String login(UserLogin request, String tableId){
        Optional<User> user=userRepository.findByUserId(request.getUserId());
        log.info("db password = {}, input password = {}", user.get().getPassword(), request.getPassword());
        if(user.get().getPassword().equals(request.getPassword())) {
            user.get().setUserTable(tableId);
            userRepository.save(user.get());
            Optional<TableInfo> table = tableRepository.findByTableId(tableId);
            log.info("table_Info : id={}, using={}, user={}",
                    table.get().getTableId(), table.get().isUsing(), table.get().getTableUser());
            table.get().setUsing(true);
            table.get().setTableUser(user.get().getUserName());
            tableRepository.save(table.get());
            log.info(table.get().toString());
            return "Success";
        }
        return "Failed";
    }

    public void logout(String tableId){
        Optional<TableInfo> table = tableRepository.findByTableId(tableId);
        Optional<User> user=userRepository.findByUserName(table.get().getTableUser());
        log.info("userId = {}, tableId={}", user.get().getUserId(),table.get().getTableId());
        // tableInfo 테이블 초기화
        table.get().setUsing(false);
        table.get().setTableUser(null);
        tableRepository.save(table.get());
        // user 테이블 초기화
        user.get().setUserTable(null);
        userRepository.save(user.get());
    }

    public User findUser(UserFind request){
        Optional<User> user = userRepository.findByUserName(request.getUserName());
        return user.get();
    }
}
