package com.southwind.controller;

import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.fegin.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;


    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {

        Object o = accountFeign.login(username, password, type);

        HashMap<String,Object> hashMap= (HashMap<String, Object>) o;

        String result = null;

        String idStr=null;
        if (o == null) {
            result = "login";
        } else {
            switch (type) {
                case "user":

                    idStr = hashMap.get("id")+"";


                    long id = Long.parseLong(idStr);
                    String nickname = (String) hashMap.get("nickname");




                    User user = new User();
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user", user);
                    result="index";
                    break;

                case "admin":

                    idStr = hashMap.get("id")+"";


                    long id2 = Long.parseLong(idStr);

                    String username2 = (String) hashMap.get("username");
                    Admin admin = new Admin();
                    admin.setId(id2);
                    admin.setUsername(username);
                    session.setAttribute("admin", admin);
                    result="main";
                    break;
            }
        }





        return result;


    }

    @GetMapping("/logout")
    public  String logout(HttpSession session){

        session.invalidate();
        return "redirect:/login.html";
    }


}
