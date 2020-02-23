package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.fegin.MenuFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFegin menuFegin;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFegin.findAll(index, limit);

    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;


    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){

        menuFegin.deleteById(id);
        return  "redirect:/menu/redirect/menu_manage";
    };

    @GetMapping("/menu_manage")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFegin.findTypes());
        return modelAndView;


    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFegin.save(menu);
        return  "redirect:/menu/redirect/menu_manage";

    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
       Menu menu= menuFegin.findById(id);
        modelAndView.addObject("menu",menuFegin.findById(id));
        modelAndView.addObject("list",menuFegin.findTypes());
        return  modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFegin.update(menu);
        return  "redirect:/menu/redirect/menu_manage";

    }


}
