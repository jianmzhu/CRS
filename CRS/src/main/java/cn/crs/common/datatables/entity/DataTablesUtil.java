package cn.crs.common.datatables.entity;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import cn.crs.common.util.ObjectUtil;

public class DataTablesUtil {
	private static DataTablesUtil dataTablesUtil = null;
	private DataTablesParam dataTablesParam;
	
	public static synchronized DataTablesUtil getInstance(){
		if(dataTablesUtil == null){
			dataTablesUtil = new DataTablesUtil();
		}
		return DataTablesUtil.dataTablesUtil;
	}
	
	public DataTablesParam createDataTablesParam(Map<String,Object> dataMap) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException{
		DataTablesParam dataTablesParam = mapToDataTablesParam(dataMap);//获取表格详细
		addDataTablesParams(dataTablesParam, dataMap);
		return dataTablesParam;
	}
	
	private DataTablesParam mapToDataTablesParam(Map<String,Object> dataMap) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException{
		dataTablesParam = new DataTablesParam();
		dataTablesParam = (DataTablesParam) ObjectUtil.convertMap(DataTablesParam.class, dataMap);
		return this.dataTablesParam;
		
	}
	
	private void addDataTablesParams(DataTablesParam dataTablesParam , Map<String,Object> dataMap) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		int colCount = Integer.parseInt(""+dataMap.get("iColumns"));//总列数
		int sortCount = Integer.parseInt(""+dataMap.get("iSortingCols"));//总排序数
		List<DataTablesColParam> dataTablesColParams = new ArrayList<DataTablesColParam>();
		List<DataTablesSortParam> dataTablesSortParams = new ArrayList<DataTablesSortParam>();
		for (int i = 0; i < colCount; i++) {
			dataTablesColParams.add(new DataTablesColParam());//初始化List<DataTablesColParam>
		}
		for (int i = 0; i < sortCount; i++) {
			dataTablesSortParams.add(new DataTablesSortParam());//初始化List<DataTablesSortParam>
		}
		Set<String> keySet = dataMap.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String strKey = (String) iterator.next();
			if(strKey.indexOf("_")!=-1){
				Object dataValue = dataMap.get(strKey);
				String[] strKeyArr = strKey.split("_");
				int colNum = Integer.parseInt(strKeyArr[1]);//列号
				String colName = strKeyArr[0];//列名
				if(!"sSortDir".equals(colName)&&!"iSortCol".equals(colName)){
					ObjectUtil.setProperty(dataTablesColParams.get(colNum), colName, dataValue);//列值
				}else{
					ObjectUtil.setProperty(dataTablesSortParams.get(colNum), colName, dataValue);//排序值
				}
			}
		}
		dataTablesParam.setDataTablesColParam(dataTablesColParams);
		dataTablesParam.setDataTablesSortParam(dataTablesSortParams);
	}
	
	public static String switchParam(String name){
        if (name.matches("[a-z]+[A-Z][a-z]+([A-Z][a-z]+)*")){  
            Pattern pattern = Pattern.compile("[A-Z]");  
            Matcher matcher = pattern.matcher(name);  
            while(matcher.find()){  
                String old = matcher.group();  
                String ne = matcher.group().toLowerCase();  
                name = name.replaceAll(old, "_"+ne);  
            }  
        }  
        return name;  
    }
	
	public static String getOrderByClause(DataTablesParam dataTablesParam){
		StringBuffer orderByClause = new StringBuffer();
		if(dataTablesParam==null){
			throw new NullPointerException("不存在dataTablesParam值");
		}else{
			List<DataTablesSortParam> dataTablesSortParams = dataTablesParam.getDataTablesSortParam();
			for (DataTablesSortParam dataTablesSortParam : dataTablesSortParams) {
				//字段可以进行排序
				if(dataTablesSortParam.getsSortDir()!=null&&!"null".equals(dataTablesSortParam.getsSortDir())){
					orderByClause.append(DataTablesUtil
							.switchParam(dataTablesParam
									.getDataTablesColParam()
									.get(dataTablesSortParam.getiSortCol())
									.getmDataProp())
							+ " " + dataTablesSortParam.getsSortDir() + ",");
				}
			}
		}
		return StringUtils.removeEnd(orderByClause.toString(), ",");
	}
}
