package cn.crs.reserve.dao;

import cn.crs.reserve.entity.SysUserPaginationSimple;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface SysUserPaginationSimpleMapper {
    
	//根据Id查找对应的用户
	public SysUserPaginationSimple selectUserById(Integer userId);
	
    //直接查找所有用户列表
    public List<SysUserPaginationSimple> getAllUserList();
    
    //查找对应名称的用户列表
    public List<SysUserPaginationSimple> selectUserByUserName(@Param("userName") String userName);
}