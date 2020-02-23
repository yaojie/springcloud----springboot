package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.fegin.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userfeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit")int limit) {
        int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userfeign.count());
        userVO.setData(userfeign.findAll(index, limit));




        return userVO;

    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;


    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userfeign.findById(id);
    }

    @GetMapping("/count")
    @ResponseBody
    public int count() {
        return userfeign.count();
    }


    @PostMapping("/save")
    public String save(User user){

        userfeign.save(user);

        return  "redirect:/user/redirect/user_manage";
    }

    @PutMapping("/update")
    public void update(User user){

        userfeign.update(user);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id ){
        userfeign.deleteById(id);
        return  "redirect:/user/redirect/user_manage";

    }


}
