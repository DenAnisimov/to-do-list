package com.example.todolist.controller;

import com.example.todolist.entity.User;
import com.example.todolist.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @Autowired
    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @GetMapping("/")
    public String login() {
        return "authentification";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute("userForm") User userForm, Model model) {
        String username = userForm.getUsername();
        String password = userForm.getPassword();

        boolean isPresent = authentificationService.signIn(username, password);

        if (isPresent) {
            return "todos";
        } else {
            model.addAttribute("invalidUsernameOrPassword", "Invalid username or password");
            return "authentification";
        }
    }
}
