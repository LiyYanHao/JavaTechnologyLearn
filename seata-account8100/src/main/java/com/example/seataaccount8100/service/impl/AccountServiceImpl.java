package com.example.seataaccount8100.service.impl;

import com.example.seataaccount8100.dao.AccountDao;
import com.example.seataaccount8100.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author liyanhao
 * @Date 2022-12-14 16:10
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {



    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
