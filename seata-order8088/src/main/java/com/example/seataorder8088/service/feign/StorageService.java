package com.example.seataorder8088.service.feign;

import com.example.seataorder8088.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liyanhao
 * @Date 2022-12-14 0:07
 */
@FeignClient(value = "seata-storage8089")
public interface StorageService {
    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
