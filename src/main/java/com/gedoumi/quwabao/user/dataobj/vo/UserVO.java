package com.gedoumi.quwabao.user.dataobj.vo;

import lombok.Data;

/**
 * 用户信息VO
 *
 * @author Minced
 */
@Data
public class UserVO {

    /**
     * 用户信息VO
     */
    private UserInfoVO userInfo;

    /**
     * 用户资产VO
     */
    private UserAssetVO userAsset;

}