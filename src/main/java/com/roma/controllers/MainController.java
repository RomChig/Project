package com.roma.controllers;

import com.roma.DAOImpl.UserDAOImplOnSpring;
import com.roma.models.User;
import com.roma.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private final UserRepository userRepository;
    private final UserDAOImplOnSpring userDAOImplOnSpring;

    @Autowired
    public MainController(UserRepository userRepository, UserDAOImplOnSpring userDAOImplOnSpring) {
        this.userRepository = userRepository;
        this.userDAOImplOnSpring = userDAOImplOnSpring;
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        System.out.println(userRepository.findByNameAndAge("Igor", 20L));
        return "main";
    }

    @PostMapping("/register")
    public String see(@RequestParam String name, @RequestParam Long age, Model model) {
        System.out.println(name + " " + age);
        User user = new User(name, age);
        userRepository.save(user);
        return "redirect:/main";
    }

    @GetMapping("/register")
    public String see(Model model) {
        return "register";
    }

    @GetMapping("/find")
    public String find(@RequestParam String name, Model model) {
        Optional<List<User>> list = userDAOImplOnSpring.findByName(name);
        List<User> users = list.get();
        model.addAttribute("users", users);
        return "redirect:/main";
    }
}
