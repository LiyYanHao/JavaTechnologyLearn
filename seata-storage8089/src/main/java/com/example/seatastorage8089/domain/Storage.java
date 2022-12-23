package com.example.seatastorage8089.domain;

import lombok.Data;

/**
 * @author liyanhao
 * @Date 2022-12-14 15:17
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
