package com.example.shardingsphereproxy8104;

import com.example.shardingsphereproxy8104.entity.User;
import com.example.shardingsphereproxy8104.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingProxyDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 读写分离测试
     * 测试读
     */
    @Test
    public void testUserSelectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testWrite(){
        User user = new User();
        user.setUname("12345");
        userMapper.insert(user);
    }


}
