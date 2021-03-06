package com.gedoumi.quwabao.common.constants;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 常量类
 *
 * @author Minced
 */
public interface Constants {

    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String API_USER_KEY = "user";
    Integer SCALE = 5;
    BigDecimal CLUB_PROFIT_STANDARD = new BigDecimal("500000.00000");
    BigDecimal TEAM_LEVEL1_PROPORTION = new BigDecimal("0.03");
    BigDecimal TEAM_LEVEL2_PROPORTION = new BigDecimal("0.06");
    BigDecimal TEAM_LEVEL3_PROPORTION = new BigDecimal("0.09");
    BigDecimal TEAM_LEVEL4_PROPORTION = new BigDecimal("0.01");
    String ASSET_NAME = "pfc";
    String MEMO = "erc20#";
    String AUTH_TOKEN = "auth-token";
    String USER_PREFIX = "挖宝客";

}
