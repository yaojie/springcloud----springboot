package com.southwind.fegin;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(Order order
    );
    @GetMapping("/order/findAllByUid/{uid}/{index}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("index") int index, @PathVariable("limit") int limit);


    @GetMapping("/order/findAllByState/{state}/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state,@PathVariable("index")
            int index,@PathVariable("limit")  int limit);


    @PutMapping("/order/updateState/{id}/{aid}/{state}")
    public void updateState(@PathVariable("id") long id,@PathVariable("aid") long aid,@PathVariable("state") int state);



    }
