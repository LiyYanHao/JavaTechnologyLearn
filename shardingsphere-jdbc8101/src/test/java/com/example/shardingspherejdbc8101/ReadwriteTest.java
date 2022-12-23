package com.example.shardingspherejdbc8101;

import com.example.shardingspherejdbc8101.entity.User;
import com.example.shardingspherejdbc8101.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liyanhao
 * @Date 2022-12-17 17:24
 */
@SpringBootTest
public class ReadwriteTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 写入数据的测试
     */
    @Test
    public void testInsert(){
        //插入测试
        User user = new User();
        user.setUname("张三丰2");
        userMapper.insert(user);
        //查询
        User user1 = userMapper.selectById(user.getId());
        System.out.println(user1);

    }
    /**
     * 事务测试
     */
    @Transactional//开启事务
    // @Rollback(value = false) spring-test会默认回滚事务，可以添加此注解提交事务
    @Test
    public void testTrans(){
        User user = new User();
        user.setUname("铁锤2");
        userMapper.insert(user);
        int i = 1 / 0;
    }

    /**
     * 读数据测试
     */
    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        List<User> users2 = userMapper.selectList(null);//执行第二次测试负载均衡
        users.forEach(System.out::println);
        users2.forEach(System.out::println);
    }


}
