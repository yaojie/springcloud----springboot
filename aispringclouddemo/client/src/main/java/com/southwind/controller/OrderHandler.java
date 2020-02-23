package com.southwind.controller;

import com.southwind.entity.*;
import com.southwind.fegin.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Menu menu = new Menu();
        menu.setId(mid);

        Order order = new Order();

        order.setUser(user);
        order.setMenu(menu);

        orderFeign.save(order);
        return "order";


    }

   @GetMapping("/findAllByUid")
   @ResponseBody
    public OrderVO findAllByUid(HttpSession session, @RequestParam("page") int page, @RequestParam("limit") int limit){

        User user = (User) session.getAttribute("user");
       long id = user.getId();


       int index = (page -1)*limit;

       return  orderFeign.findAllByUid(id,index,limit);



   }



   @GetMapping("findAllByState")
   @ResponseBody
 public OrderVO findAllByState(@RequestParam("page")
            int page,@RequestParam("limit")  int limit){
        int index = (page -1)* limit;
        int state = 0;
        return orderFeign.findAllByState(state,index, limit);



   }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") long id,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        long aid=admin.getId();
        int state = 1;
        orderFeign.updateState(id, aid, state);

        return "redirect:/menu/redirect/order_handler";
    }




}
