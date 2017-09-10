package cn.crs.reserve.service;

import java.util.List;

import cn.crs.common.pagination.PagedResult;
import cn.crs.reserve.entity.SysUserPaginationSimple;

public interface SysUserPaginationSimpleService {

	//通过ID查找对应的用户
	public SysUserPaginationSimple selectUserById(Integer userId);
	
	// 通过用户名查询对应的用户列表
	public List<SysUserPaginationSimple> selectUserByUserName(String userName);
	
	//直接查找所有用户列表
    public List<SysUserPaginationSimple> getAllUserList();
    
    
    /**
	 * 
	 * @param userName 查询条件，可为空
	 * @param pageNo 查询条件，可为空，默认取1
	 * @param pageSize 查询条件，可为空，默认取10
	 * @return
	 */
	public PagedResult<SysUserPaginationSimple> queryByPage(String userName,Integer pageNo,Integer pageSize);
	
	/**
	 * 
	 * @param userName 查询条件，可为空
	 * @param pageOffset 查询条件，可为空，默认取0
	 * @param pageSize 查询条件，可为空，默认取10
	 * @return
	 */
	public PagedResult<SysUserPaginationSimple> queryByPageOffset(String userName,Integer pageOffset,Integer pageSize);
}
