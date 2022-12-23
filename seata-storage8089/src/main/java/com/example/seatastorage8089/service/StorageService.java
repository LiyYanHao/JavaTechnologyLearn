package com.example.seatastorage8089.service;

/**
 * @author liyanhao
 * @Date 2022-12-14 15:19
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}
