package com.gedoumi.quwabao.user.mapper;

import com.gedoumi.quwabao.user.dataobj.dto.UserProfitDTO;
import com.gedoumi.quwabao.user.dataobj.model.UserProfit;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户收益Mapper
 *
 * @author Minced
 */
@Mapper
public interface UserProfitMapper {

    /**
     * 根据用户ID查询用户收益列表
     *
     * @param userId 用户ID
     * @return 用户收益对象
     */
    List<UserProfit> selectByUserId(Long userId);

    /**
     * 查询当日静态收益列表
     *
     * @param date 日期
     * @return 用户收益
     */
    List<UserProfit> selectByDate(String date);

    /**
     * 根据日期查询指定用户的收益
     *
     * @param userId     用户ID
     * @param date       日期
     * @param rentStatus 矿机状态
     * @return 用户收益DTO对象
     */
    UserProfitDTO selectByuserIdAndDate(Long userId, String date, Integer rentStatus);

    /**
     * 根据日期查询当日的总静态收益
     *
     * @param date 日期
     * @return 总静态收益
     */
    BigDecimal selectTotalStaticProfit(String date);

    /**
     * 创建用户收益
     *
     * @param userProfit 用户收益对象
     * @return 数据库受影响行数
     */
    Integer insert(UserProfit userProfit);

    /**
     * 批量添加用户收益
     *
     * @param userProfits 用户收益集合
     * @return 数据库受影响行数
     */
    Integer insertBatch(List<UserProfit> userProfits);

    /**
     * 根据ID更新用户收益
     *
     * @param userProfit 用户收益对象
     * @return 数据库受影响行数
     */
    Integer updateById(UserProfit userProfit);

    /**
     * 根据用户ID批量更新用户收益
     *
     * @param userProfits 用户收益集合
     * @return 数据库受影响行数
     */
    Integer updateBatchByUserId(List<UserProfit> userProfits);

}
