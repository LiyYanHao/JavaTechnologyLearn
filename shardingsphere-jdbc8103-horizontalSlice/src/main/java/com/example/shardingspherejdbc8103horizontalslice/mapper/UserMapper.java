package com.example.shardingspherejdbc8103horizontalslice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingspherejdbc8103horizontalslice.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyanhao
 * @Date 2022-12-17 17:14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
