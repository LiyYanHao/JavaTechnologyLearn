package com.example.seataorder8088.controller;

import com.example.seataorder8088.domain.CommonResult;
import com.example.seataorder8088.domain.Order;
import com.example.seataorder8088.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyanhao
 * @Date 2022-12-14 16:20
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }
}
