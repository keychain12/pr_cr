package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User("", ""));
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("userCount", userService.getUserCount());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, RedirectAttributes redirectAttributes) {

        String message = userService.addUser(user);
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/register";

    }

    @PostMapping("/delete")
    public String delete(Long id) {
         userService.deleteUser(id);
        return "redirect:/register";
    }

    @PostMapping("/update-email")
    public String modifyEmail(Long id, String newEmail) {
        userService.updateUserEmail(id, newEmail);

        return "redirect:/register";

    }


}
