package cn.crs.reserve.dao;

import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.entity.SysUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExampleWithBLOBs(SysUserExample example);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExampleWithBLOBs(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKeyWithBLOBs(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    /*****************自定义添加**********************/
    //查看指定id的SysUser
    public SysUser getUserInfoById(int id);
    
    //查看指定jobNo的SysUser
    public SysUser getUserInfoByJobNo(String jobNo);
    
    //通过分页查询对应的用户列表
    public List<SysUser> getUserListWithPaginated(@Param("start") int start, @Param("size") int size);
    
    //直接查找所有用户列表
    public List<SysUser> getAllUserList();
    
    // 查询所有用户的数量
  	public int countSysUserByTypeNum();
}