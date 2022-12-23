package com.example.shardingspherejdbc8102.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingspherejdbc8102.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyanhao
 * @Date 2022-12-17 18:04
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
