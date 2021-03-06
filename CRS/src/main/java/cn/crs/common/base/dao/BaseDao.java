package cn.crs.common.base.dao;

import java.util.List;
import java.util.Map;

import cn.crs.common.dto.PageTool;

public interface BaseDao {
	void add(Object o, String namespace);
	List<?> list(String namespace);
	List<?> list_role(String namespace,Object role);
	List<?> list_key(String namespace,String key);
	List<?> list_key_role(String namespace,String key,Object role);
	Object one(String namespace, String id);
	Object one(String namespace, Map<String,Object> role);
	Object one_key_role(String namespace,String key, Object id);
	List<?> page(String namespace,PageTool pageTool);
	List<?> page(String namespace,PageTool pageTool,String TYPE);
	void update(String namespace,Object o);
	void update_key_role(String namespace,String key,Object o) ;
	void delete(String namespace,String id);
	void delete_key_role(String namespace,String key,Object role);
	Integer count(String namespace,String role);
}
