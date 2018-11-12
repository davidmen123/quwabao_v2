package com.gedoumi.quwabao.user.dataobj.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gedoumi.quwabao.sys.dataobj.model.Rent;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户租用矿机信息
 *
 * @author Minced
 */
@TableName("user_rent")
@Data
public class UserRent {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 矿机价格
     */
    private BigDecimal rentAsset;

    /**
     * 上次挖矿收益
     */
    private BigDecimal lastDig;

    /**
     * 已经获得的收益
     */
    private BigDecimal alreadyDig;

    /**
     * 总收益
     */
    private BigDecimal totalAsset;

    /**
     * 更新时间
     */
    private Date updateTime = new Date();

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 矿机类型
     */
    private Integer rentType;

    /**
     * 矿机
     */
    private Rent rent;

    /**
     * 矿机状态
     * 0:已经结束
     * 1:正在运行
     */
    private Integer rentStatus;

}
