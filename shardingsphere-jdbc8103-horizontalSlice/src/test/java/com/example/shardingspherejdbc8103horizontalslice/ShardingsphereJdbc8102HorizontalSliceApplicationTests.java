package com.example.shardingspherejdbc8103horizontalslice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingspherejdbc8103horizontalslice.entity.Dict;
import com.example.shardingspherejdbc8103horizontalslice.entity.Order;
import com.example.shardingspherejdbc8103horizontalslice.entity.OrderItem;
import com.example.shardingspherejdbc8103horizontalslice.entity.OrderVo;
import com.example.shardingspherejdbc8103horizontalslice.mapper.DictMapper;
import com.example.shardingspherejdbc8103horizontalslice.mapper.OrderItemMapper;
import com.example.shardingspherejdbc8103horizontalslice.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingsphereJdbc8102HorizontalSliceApplicationTests {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private DictMapper dictMapper;

    /**
     * 水平分片: 插入数据测试
     * 映射的逻辑表  所以插入会报错
     * java.lang.IllegalStateException: Insert statement does not support sharding table routing to multiple data nodes.
     */
    @Test
    public void testinsertOrder() {
        Order order = new Order();
        order.setOrderNo("liyanhao001");
        order.setUserId(1l);
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }

    /**
     * 水平分片: 插入数据测试
     * 映射的逻辑表  所以插入会报错
     * 配置分布式id生成策略
     *
     * @TableId(type = IdType.ASSIGN_ID)
     * 因为没有指定分库分表算法 所以只配置单个数据源
     * spring.shardingsphere.rules.sharding.tables.t_order.actual-data-nodes=server-order0.t_order0
     */
    @Test
    public void testinsertOrder2() {
        Order order = new Order();
        order.setOrderNo("liyanhao001");
        order.setUserId(1l);
        order.setAmount(new BigDecimal(100));
        orderMapper.insert(order);
    }


    /**
     * 水平分分片:分库插入数据测试
     */
    @Test
    public void testInsertOrderDatabaseStrategy() {
        for (long i = 0; i < 4; i++) {
            Order order = new Order();
            order.setOrderNo("liyanhao01-hslice");
            order.setUserId(i + 1);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }
    }


    /**
     * 水平分片：分表插入数据测试
     */
    @Test
    public void testInsertOrderTableStrategy() {

        for (long i = 1; i < 5; i++) {

            Order order = new Order();
            order.setOrderNo("liyanhao" + i);
            order.setUserId(1L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }

        for (long i = 5; i < 9; i++) {

            Order order = new Order();
            order.setOrderNo("liyanhao" + i);
            order.setUserId(2L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
        }
    }


    //查询测试

    /**
     * 水平分片 查询所有记录
     * 查询两个数据源 每个数据源使用union all 连接两个表
     */
    @Test
    public void testShardingSelectAll() {
        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

    /**
     * 水平分片 根据user_id查询记录
     * 查询了一个数据源 每个数据源中使用union all 链接两个表
     */
    @Test
    public void testShardingSelectByUserId() {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", 1L);
        List<Order> orders = orderMapper.selectList(orderQueryWrapper);
        orders.forEach(System.out::println);
    }

    //测试关联表插入
    @Test
    public void testInsertOrderAndOrderItem() {
        for (long i = 1; i < 9; i++) {
            Order order = new Order();
            order.setOrderNo("liyanhao-关联插入测试A" + i);
            order.setUserId(1L);
            orderMapper.insert(order);
            for (long j = 1; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("liyanhao-关联插入测试A" + i);
                orderItem.setUserId(1L);
                orderItem.setPrice(new BigDecimal(3));
                orderItem.setCount(2);
                orderItemMapper.insert(orderItem);
            }
        }

        for (long i = 5; i < 9; i++) {

            Order order = new Order();
            order.setOrderNo("liyanhao-关联插入测试B" + i);
            order.setUserId(2L);
            orderMapper.insert(order);

            for (int j = 0; j < 3; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderNo("liyanhao-关联插入测试B" + i);
                orderItem.setUserId(2L);
                orderItem.setPrice(new BigDecimal(3));
                orderItem.setCount(3);
                orderItemMapper.insert(orderItem);
            }
        }
    }

    /**
     * 测试关联查询
     */
    @Test
    public void testgetOrderAmounnt() {
        List<OrderVo> orderAmount = orderMapper.getOrderAmount();
        orderAmount.forEach(System.out::println);
    }

    /**
     * 测试广播表
     * 广播表:每个服务器中的t_dict同事添加了新数据
     */
    @Test
    public void testBroadcast(){
        Dict dict = new Dict();
        dict.setDictType("type1");
        dictMapper.insert(dict);
    }
    /**
     * 广播表
     * 查询草走，只从一个节点获取数据
     * 随机负载均衡规则
     */
    @Test
    public void testSelectBroadcast(){
        List<Dict> dicts = dictMapper.selectList(null);
        dicts.forEach(System.out::println);
    }


}












