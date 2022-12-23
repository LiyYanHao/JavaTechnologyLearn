package com.example.shardingspherejdbc8103horizontalslice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingspherejdbc8103horizontalslice.entity.Order;
import com.example.shardingspherejdbc8103horizontalslice.entity.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liyanhao
 * @Date 2022-12-17 18:04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select({"SELECT o.order_no, SUM(i.price * i.count) AS amount",
            "FROM t_order o JOIN t_order_item i ON o.order_no = i.order_no",
            "GROUP BY o.order_no"})
    List<OrderVo> getOrderAmount();
}
