package cn.crs.test;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.crs.common.datatables.entity.DataTablesUtil;

@SuppressWarnings({"rawtypes","unchecked"})
public class DataTablesUtilTest {
	
	@Test
	public void testGenerateDataTables() throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException{
		Map map = new HashMap();
		map.put("sEcho", 1);
		map.put("iColumns", 7);
		map.put("sColumns", ",,,,,,,");
		map.put("iDisplayStart", 0);
		map.put("iDisplayLength", 10);
		map.put("sSearch", "");
		map.put("bRegex", false);
		map.put("iSortingCols", 1);
		
		map.put("mDataProp_0", "userId");
		map.put("sSearch_0", "");
		map.put("bRegex_0", false);
		map.put("bSearchable_0", false);
		map.put("bSortable_0", true);
		map.put("iSortCol_0", 3);
		map.put("sSortDir_0", "asc");
		
		
		map.put("mDataProp_1", "userJobno");
		map.put("sSearch_1", "");
		map.put("bRegex_1", false);
		map.put("bSearchable_1", true);
		map.put("bSortable_1", true);

		map.put("mDataProp_2", "userName");
		map.put("sSearch_2", "");
		map.put("bRegex_2", false);
		map.put("bSearchable_2", true);
		map.put("bSortable_2", true);
		
		map.put("mDataProp_3", "userPhone");
		map.put("sSearch_3", "");
		map.put("bRegex_3", false);
		map.put("bSearchable_3", true);
		map.put("bSortable_3", true);
		
		map.put("mDataProp_4", "userEmail");
		map.put("sSearch_4", "");
		map.put("bRegex_4", false);
		map.put("bSearchable_4", true);
		map.put("bSortable_4", true);
		
		map.put("mDataProp_5", "createTime");
		map.put("sSearch_5", "");
		map.put("bRegex_5", false);
		map.put("bSearchable_5", true);
		map.put("bSortable_5", true);
		
		map.put("mDataProp_6", "null");
		map.put("sSearch_6", "");
		map.put("bRegex_6", false);
		map.put("bSearchable_6", true);
		map.put("bSortable_6", true);
		
		
//		System.out.println(DataTablesUtil.getInstance().createDataTablesParam(map));
		
		System.out.println(DataTablesUtil.getOrderByClause(DataTablesUtil.getInstance().createDataTablesParam(map)));
	}
}
