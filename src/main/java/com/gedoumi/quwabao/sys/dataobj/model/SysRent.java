package com.gedoumi.quwabao.sys.dataobj.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 矿机
 *
 * @author Minecd
 */
@Alias("SysRent")
@Data
public class SysRent {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 矿机价格
     */
    private BigDecimal money;

    /**
     * 矿机名称
     */
    private String name;

    /**
     * 每日收益
     */
    private BigDecimal profitDay;

    /**
     * 预计收益
     */
    private BigDecimal profitMoney;

    /**
     * 总收益
     */
    private BigDecimal profitMoneyExt;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 矿机类型
     */
    private Integer rentCode;

    /**
     * 矿机状态
     * 0:已关闭租用
     * 1:已开启租用
     */
    private Integer rentStatus;

}
