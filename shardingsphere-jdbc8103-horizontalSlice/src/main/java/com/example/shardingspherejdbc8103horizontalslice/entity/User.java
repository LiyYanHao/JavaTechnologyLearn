package com.example.shardingspherejdbc8103horizontalslice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liyanhao
 * @Date 2022-12-17 17:13
 */
@TableName("t_user")
@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String uname;
}

