package com.gedoumi.quwabao.user.mapper;

import com.gedoumi.quwabao.user.dataobj.model.UserTeamExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户团队Mapper
 *
 * @author Minced
 */
@Mapper
public interface UserTeamExtMapper {

    /**
     * 根据用户ID查询
     *
     * @param userId 用户ID
     * @return 用户团队对象
     */
    UserTeamExt selectByUserId(Long userId);

    /**
     * 根据上级用户ID查询下级用户ID集合
     *
     * @param parentId 上级用户ID集合
     * @return 下级用户ID集合
     */
    List<Long> selectUserIdsByParentId(List<Long> parentId);

    /**
     * 创建用户团队
     *
     * @param userTeamExt 用户团队对象
     * @return 数据库受影响行数
     */
    Integer insert(UserTeamExt userTeamExt);

    /**
     * 根据ID用户团队
     *
     * @param userTeamExt 用户团队对象
     * @return 数据库受影响行数
     */
    Integer updateById(UserTeamExt userTeamExt);

}
