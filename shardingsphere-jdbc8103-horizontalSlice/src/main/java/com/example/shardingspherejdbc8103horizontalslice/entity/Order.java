package com.example.shardingspherejdbc8103horizontalslice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liyanhao
 * @Date 2022-12-17 18:04
 */

@TableName("t_order")//映射的逻辑表 所以不知道具体插入的那个服务器
@Data
public class Order {
    //@TableId(type = IdType.ASSIGN_ID)//分布式id 基于雪花算法
    @TableId(type = IdType.ASSIGN_ID)
    private String orderNo;
    private Long userId;
    private BigDecimal amount;
}
