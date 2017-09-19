package cn.crs.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class ObjectUtil {
	
	private static Logger log = Logger.getLogger(ObjectUtil.class);
	
	/** 
     * 将一个 JavaBean 对象转化为一个  Map 
     * @param bean 要转化的JavaBean 对象 
     * @return 转化出来的  Map 对象 
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws IllegalAccessException 如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
     */  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public static Map convertBean(Object bean)  
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {  
        Class type = bean.getClass();  
        Map returnMap = new HashMap();  
        BeanInfo beanInfo = Introspector.getBeanInfo(type);  
  
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
            if (!propertyName.equals("class")) {  
                Method readMethod = descriptor.getReadMethod();  
                Object result = readMethod.invoke(bean, new Object[0]);  
                if (result != null) {  
                    returnMap.put(propertyName, result);  
                } else {  
                    returnMap.put(propertyName, "");  
                }  
            }  
        }  
        return returnMap;  
    }



    /** 
     * 将一个 Map 对象转化为一个 JavaBean 
     * @param type 要转化的类型 
     * @param map 包含属性值的 map 
     * @return 转化出来的 JavaBean 对象 
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws IllegalAccessException 如果实例化 JavaBean 失败 
     * @throws InstantiationException 如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
     */  
    @SuppressWarnings("rawtypes")  
    public static Object convertMap(Class type, Map map){  
        BeanInfo beanInfo = null;
        Object obj = null;
        try {
        	// 获取类属性  
			beanInfo = Introspector.getBeanInfo(type);
		} catch (IntrospectionException e) {
			log.error("获取bean失败",e);
			return obj;
		} 
        
        try {
			obj = type.newInstance(); // 创建 JavaBean 对象  
		} catch (InstantiationException e) {
			log.error("创建 JavaBean对象失败，InstantiationException",e);
			return obj;
		} catch (IllegalAccessException e) {
			log.error("创建 JavaBean对象失败，IllegalAccessException",e);
			return obj;
		}
  
        // 给 JavaBean 对象的属性赋值  
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
        for (int i = 0; i< propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
  
            if (map.containsKey(propertyName)) {  
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。  
                Object value = map.get(propertyName);  
  
                Object[] args = new Object[1];  
                args[0] = value;  
  
                try {
					descriptor.getWriteMethod().invoke(obj, args);
				} catch (IllegalAccessException e) {
					log.error("注入JavaBean属性值失败，IllegalAccessException",e);
					return obj;
				} catch (IllegalArgumentException e) {
					log.error("注入JavaBean属性值失败，IllegalArgumentException",e);
					return obj;
				} catch (InvocationTargetException e) {
					log.error("注入JavaBean属性值失败，InvocationTargetException",e);
					return obj;
				}  
            }  
        }  
        return obj;  
    }
    
    public static void setProperty(Object obj,String propertyName,Object value){  
        Class<? extends Object> clazz = obj.getClass();//获取对象的类型  
        PropertyDescriptor pd = PropertyUtil.getPropertyDescriptor(clazz,propertyName);//获取 clazz 类型中的 propertyName 的属性描述器  
        Method setMethod = pd.getWriteMethod();//从属性描述器中获取 set 方法  
            try {
				setMethod.invoke(obj, new Object[]{value});//调用 set 方法将传入的value值保存属性中去  
			} catch (IllegalAccessException e) {
				log.error("注入JavaBean属性值失败，IllegalAccessException",e);
			} catch (IllegalArgumentException e) {
				log.error("注入JavaBean属性值失败，IllegalArgumentException",e);
			} catch (InvocationTargetException e) {
				log.error("注入JavaBean属性值失败，InvocationTargetException",e);
			}  
    }  
}
