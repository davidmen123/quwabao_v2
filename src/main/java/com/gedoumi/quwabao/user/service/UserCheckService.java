package com.gedoumi.quwabao.user.service;

import com.gedoumi.quwabao.common.utils.CipherUtils;
import com.gedoumi.quwabao.user.mapper.UserCheckMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户验证Service
 *
 * @author Minced
 */
@Service
public class UserCheckService {

    @Resource
    private UserCheckMapper userCheckMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 查询手机号是否被使用
     *
     * @param mobile 手机号
     * @return Boolean
     */
    public Boolean checkMobilePhone(String mobile) {
        return userCheckMapper.countByMobilePhone(mobile) != 0;
    }

    /**
     * 验证邀请码是否对应一个用户
     *
     * @param inviteCode 邀请码
     * @return Boolean
     */
    public Boolean checkInviteCode(String inviteCode) {
        return userCheckMapper.countByInviteCode(inviteCode) != 0;
    }

    /**
     * 验证用户名的有效性
     *
     * @param username 用户名
     * @return Boolean
     */
    public Boolean checkUsername(String username) {
        return userCheckMapper.countByUsername(username) != 0;
    }

    /**
     * 产生验证码
     *
     * @param mobile 手机号
     * @return 验证码
     */
    public String generateValidateCode(String mobile) {
        String validateCode = CipherUtils.generateValidateCode();
        redisTemplate.opsForValue().set("reg:" + mobile, validateCode);
        return validateCode;
    }

}