package com.example.seataorder8088.service;

import com.example.seataorder8088.domain.Order;

/**
 * @author liyanhao
 * @Date 2022-12-14 0:06
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
