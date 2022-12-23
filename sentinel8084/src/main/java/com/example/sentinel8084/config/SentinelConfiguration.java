package com.example.sentinel8084.config;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @author liyanhao
 * @Date 2022-12-09 10:10
 */
public class SentinelConfiguration {
    public SentinelConfiguration() {
        //配置规则
        initFlowRules();

        while (true) {
            //1.5.0版本开始可以直接利用try-with-resources特性
            try (Entry entry = SphU.entry("HelloWorld")) {
                //被保护的逻辑
                System.out.println("hello world");

            } catch (BlockException exception) {
                //处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

    private void initFlowRules() {
        ArrayList<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setRefResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //set limit QPS to 20
        rule.setCount(1);
        FlowRuleManager.loadRules(rules);
    }
}
