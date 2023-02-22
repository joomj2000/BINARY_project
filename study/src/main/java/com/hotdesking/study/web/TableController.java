package com.hotdesking.study.web;

import com.hotdesking.study.domain.TableInfo;
import com.hotdesking.study.domain.TableRequest;
import com.hotdesking.study.service.TableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {
    private final TableService tableService;

    @GetMapping("/confirmation")
    public String showDesk(Model model){


        return "confirmation";
    }
}
