package com.example.shardingspherejdbc8103horizontalslice.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liyanhao
 * @Date 2022-12-19 9:53
 */
@Data
public class OrderVo {
    private String orderNo;
    private BigDecimal amount;
}
