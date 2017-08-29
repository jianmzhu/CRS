package cn.crs.reserve.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.exception.UserLoginException;

public interface SysUserService {

	// 通过ID查询用户信息
	public SysUser getUserInfoById(int id);
	
	//直接查找所有用户列表
    public List<SysUser> getAllUserList();
    
    // 查询所有的须知
 	public List<SysUser> findSysUserByType(int start, int size);

 	// 查询所有的须知的数量
 	public int countSysUserByTypeNum();
 	
 	/**
	 * 用户登录，根据工号进行登录
	 * 
	 * @param userJobNo
	 *            登录的工号
	 * @param passWord
	 *            登录的密码
	 * @return
	 * @throws Exception
	 */
	public SysUser login(String userJobNo, String userPassword, HttpServletRequest request) throws UserLoginException;

}
