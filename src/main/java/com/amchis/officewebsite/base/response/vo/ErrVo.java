package com.amchis.officewebsite.base.response.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 错误数据封装
 *
 * @author wenhao
 * Create at 2019-10-22 11:10
 */
@Data
public class ErrVo {

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 货物名称
     */
    private String productName;

    /**
     * 数量
     */
    private BigDecimal number=BigDecimal.ZERO;

    /**
     * 数量
     */
    private BigDecimal availableNumber=BigDecimal.ZERO;


}