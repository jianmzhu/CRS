package cn.crs.common.regutil;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.crs.common.datatables.entity.DataTablesParam;
import cn.crs.common.datatables.entity.DataTablesUtil;

import com.github.pagehelper.PageHelper;

/**
 * 分页通用工具
 * 
 * 开放工具类，spring初始化bean并且管理，提供外部调用
 * 
 * @author xiaoming
 *
 */
@Component
public class CommonPageHelper {
	private static Logger log = LoggerFactory.getLogger(CommonPageHelper.class);
	
	public Map<String, Object> doPage(Map<String, Object> pageJsonMap) {
		log.debug("进入到CommonPageHelper的当前线程：", Thread.currentThread().getName());
		//回调值部分
		Integer draw = Integer.parseInt((pageJsonMap.get("sEcho")==null?"0":pageJsonMap.get("sEcho"))+"");//默认为零的次数传输
		Map<String,Object> extraData = new HashMap<String,Object>();
		extraData.put("draw", draw);
		
		//分页部分
		Integer pageStart = Integer.parseInt((pageJsonMap.get("iDisplayStart")==null?"1":pageJsonMap.get("iDisplayStart"))+"");//查询第几条 默认第一条开始
		Integer pageSize = Integer.parseInt((pageJsonMap.get("iDisplayLength")==null?"10":pageJsonMap.get("iDisplayLength"))+"");//每页长度 默认10条
		Integer pageNumber = (pageStart + 1)/pageSize + 1;//页数
		//TODO 空值处理
		log.debug("处理后，页面参数为：pageStart{},pageSize{}", pageStart,pageSize);
		log.debug("处理后，页面参数为：pageNumber{}", pageNumber);
		pageStart = pageStart == null?0:pageStart;
		pageSize = pageSize == null?10:pageSize;
		if(pageSize>0){
			PageHelper.offsetPage(pageStart,pageSize);  //pageOffset是告诉拦截器说我要开始分页了。分页参数是这两个,pageOffset为位移，pageSize为每页条数。
		}else{
			PageHelper.startPage(1, 0);
		}
		
		//排序部分
		DataTablesParam dataTablesParam = null;
		dataTablesParam = DataTablesUtil.getInstance().createDataTablesParam(pageJsonMap);//获取当前datatables送进的值
		if(dataTablesParam!=null){
			log.debug("dataTablesParam对象为：" + dataTablesParam.toString());
			String orderByClause = DataTablesUtil.getOrderByClause(dataTablesParam);
			log.debug("orderByClause为：" + orderByClause);
			PageHelper.orderBy(orderByClause);
//			sysUserExample.setOrderByClause(orderByClause);
		}
		return extraData;
	}
}
