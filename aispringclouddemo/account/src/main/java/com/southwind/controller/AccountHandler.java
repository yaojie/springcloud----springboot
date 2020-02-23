package com.southwind.controller;

import com.southwind.entity.Admin;
import com.southwind.repository.AdminRepository;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,
                        @PathVariable("password") String password, @PathVariable("type") String type) {
        Object o = null;

        switch (type) {
            case "user":
                o = userRepository.login(username, password);

                break;
            case "admin":
                o = adminRepository.login(username, password);

                break;

        }
        return o;


    }





}
