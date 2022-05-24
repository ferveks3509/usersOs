package com.users.controller;

import com.users.service.FindUsers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final FindUsers findUsers;

    public IndexController(FindUsers findUsers) {
        this.findUsers = findUsers;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String users(@RequestParam("userName") String userName) {
        if (userName.isEmpty()) {
            throw new NullPointerException("Поле с userName не заполнено");
        }
        if (findUsers.checkUserNameInList(userName)) {
            return "findUser";
        } else {
            return "notFind";
        }
    }
}
