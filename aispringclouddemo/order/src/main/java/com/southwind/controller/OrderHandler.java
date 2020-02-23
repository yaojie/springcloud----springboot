package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("index") int index, @PathVariable("limit") int limit) {

        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(uid, index, limit));
        return orderVO;





    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") long uid) {
        return orderRepository.countByUid(uid);

    }
@GetMapping("/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state,@PathVariable("index")
        int index,@PathVariable("limit")  int limit){
    OrderVO orderVO = new OrderVO();
    orderVO.setData(orderRepository.findAllByState(state, index, limit));
    orderVO.setMsg("");

    orderVO.setCount(orderRepository.countByState(state));
    return orderVO;


}
@PutMapping("/updateState/{id}/{aid}/{state}")
    public void updateState(@PathVariable("id") long id,@PathVariable("aid") long aid,@PathVariable("state") int state){
        orderRepository.updateState(id, aid, state);


}

}
