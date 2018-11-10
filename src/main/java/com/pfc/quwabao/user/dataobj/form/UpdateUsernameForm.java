package com.pfc.quwabao.user.dataobj.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 修改用户名表单
 *
 * @author Minced
 */
@Data
public class UpdateUsernameForm {

    /**
     * 用户名
     */
    @NotBlank
    private String userName;

}