package com.pfc.quwabao.user.mapper;

import com.pfc.quwabao.QuwabaoApplicationTests;
import com.pfc.quwabao.user.dataobj.dto.UserRentNumberDTO;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

@Component
public class UserRentMapperTest extends QuwabaoApplicationTests {

    @Resource
    private UserRentMapper userRentMapper;

    @Test
    public void countUserRentsByIds() {
        List<UserRentNumberDTO> rentNumbers = userRentMapper.countUserRentsByIds(Lists.newArrayList(138L), 1);
        System.out.println(rentNumbers);
    }

    @Test
    public void queryTotalRentAsset() {
        BigDecimal totalRentAsset = userRentMapper.queryTotalRentAsset(Lists.newArrayList(138L));
        System.out.println(totalRentAsset);
    }

}