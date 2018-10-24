package com.gedoumi.quwabao.common.enums;

import lombok.Getter;

@Getter
public enum UserValidateStatus {

    Init(0, "未认证"),
    Pass(1, "通过实名认证"),
    UnPass(2, "未通过实名认证");

    private int value;

    private String name;

    UserValidateStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

}
