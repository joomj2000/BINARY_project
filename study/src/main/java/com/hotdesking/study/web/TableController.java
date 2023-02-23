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

import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {
    private final TableService tableService;

    @GetMapping("/home")
    public String home(Model model){
        //model.addAttribute("data","어서오세요!");
        TableInfo a1 = tableService.findTable("a1");
        TableInfo a2 = tableService.findTable("a2");
        TableInfo b1 = tableService.findTable("b1");
        TableInfo b2 = tableService.findTable("b2");
        TableInfo b3 = tableService.findTable("b3");
        TableInfo b4 = tableService.findTable("b4");
        TableInfo b5 = tableService.findTable("b5");
        TableInfo b6 = tableService.findTable("b6");
        model.addAttribute("a1", a1);
        model.addAttribute("a2", a2);
        model.addAttribute("b1", b1);
        model.addAttribute("b2", b2);
        model.addAttribute("b3", b3);
        model.addAttribute("b4", b4);
        model.addAttribute("b5", b5);
        model.addAttribute("b6", b6);
        return "index";
    }
    @GetMapping("/confirmation")
    public String showDesk(Model model){
        TableInfo a1 = tableService.findTable("a1");
        TableInfo a2 = tableService.findTable("a2");
        TableInfo b1 = tableService.findTable("b1");
        TableInfo b2 = tableService.findTable("b2");
        TableInfo b3 = tableService.findTable("b3");
        TableInfo b4 = tableService.findTable("b4");
        TableInfo b5 = tableService.findTable("b5");
        TableInfo b6 = tableService.findTable("b6");
        model.addAttribute("a1", a1);
        model.addAttribute("a2", a2);
        model.addAttribute("b1", b1);
        model.addAttribute("b2", b2);
        model.addAttribute("b3", b3);
        model.addAttribute("b4", b4);
        model.addAttribute("b5", b5);
        model.addAttribute("b6", b6);

        return "confirmation";
    }


}
