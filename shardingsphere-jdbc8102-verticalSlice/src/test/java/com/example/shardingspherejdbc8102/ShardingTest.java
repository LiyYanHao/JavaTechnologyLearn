package com.example.shardingspherejdbc8102;

import com.example.shardingspherejdbc8102.entity.Order;
import com.example.shardingspherejdbc8102.entity.User;
import com.example.shardingspherejdbc8102.mapper.OrderMapper;
import com.example.shardingspherejdbc8102.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author liyanhao
 * @Date 2022-12-17 18:06
 */
@SpringBootTest
public class ShardingTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 垂直分片：插入数据测试
     */
    @Test
    public void testInsertOrderAndUser(){
        User user = new User();
        user.setUname("昊哥");
        userMapper.insert(user);

        Order order = new Order();
        order.setOrderNo("liyanhao001");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }
    /**
     * 垂直分片：查询数据库
     */
    @Test
    public void testSelectFromOrderAndUser(){
        User user = userMapper.selectById(1l);
        Order order = orderMapper.selectById(user.getId());
        System.out.println(user);
        System.out.println(order);
    }



}
