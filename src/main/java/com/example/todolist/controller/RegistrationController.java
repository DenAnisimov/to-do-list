package com.example.todolist.controller;

import com.example.todolist.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/registration")
    public String openRegistrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
