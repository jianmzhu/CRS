package cn.crs.reserve.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

import cn.crs.common.util.DateUtil;
import cn.crs.reserve.entity.CarTimesDtl;
import cn.crs.reserve.entity.CarTimesDtlExample;
import cn.crs.reserve.entity.CarTimesDtlExample.Criteria;
import cn.crs.reserve.service.CarTimesDtlService;
import cn.crs.reserve.service.SysUserService;

@Controller
public class CalendarPageController {
	private static Logger log = LoggerFactory.getLogger(CalendarPageController.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private CarTimesDtlService carTimesDtlService;
	
	/**
	 * 首页日历显示（弹出日历页面，页面数据用jquery的ajax进行异步加载）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/calendarPage", method = RequestMethod.GET)
	public String homeCalendarPage(Model model) {
		log.debug("用户主页日历显示...");
		//传输最近两个月的数据，当月and下月
//		CarTimesDtlExample carTimesDtlExample = new CarTimesDtlExample();
//		Criteria criteria = carTimesDtlExample.createCriteria();
		//查找上月至下月之间的已约车记录
//		criteria.andBookDateBetween(DateUtil.getFirstDayOfLastMonth(), DateUtil.getLastDayOfNextMonth());
//		List<CarTimesDtl> books= carTimesDtlService.selectByExample(carTimesDtlExample);
//		model.addAttribute("books", books);//预约的记录
		return "indexPages/indexCalendarPage";
	}
	
	/**
	 * 首页日历显示（弹出日历页面，页面数据用jquery的ajax进行异步加载）
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/calendarPage/getCalendarData", method = RequestMethod.GET)
	public void getCalendarData(HttpServletRequest request,  
            HttpServletResponse response, HttpSession session) throws IOException {
		log.debug("主页加载日历项目...");
		String jsonString = "";//json字符串
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();//查询出的list
		
		//传输最近两个月的数据，当月and下月
		CarTimesDtlExample carTimesDtlExample = new CarTimesDtlExample();
		Criteria criteria = carTimesDtlExample.createCriteria();
		//查找上月至下月之间的已约车记录
		criteria.andBookDateBetween(DateUtil.getFirstDayOfLastMonth(), DateUtil.getLastDayOfNextMonth());
		List<CarTimesDtl> books= carTimesDtlService.selectByExample(carTimesDtlExample);
		
		if(books.size()>0){
			for (int i = 0; i < books.size(); i++) {
				CarTimesDtl carTimesDtlTemp = (CarTimesDtl)books.get(i);
				Map<String,Object> tempMap = new HashMap<String,Object>();
				tempMap.put("id", carTimesDtlTemp.getBookId());
				//处理摘要
				tempMap.put("title", carTimesDtlTemp.getBookSumm()+" "+carTimesDtlTemp.getTimesId());
				//处理时间
				String[] times = carTimesDtlTemp.getTimesId().split("-");
				tempMap.put("start", DateUtil.getDateFormat(carTimesDtlTemp.getBookDate())+" "+times[0]);//开始时间
				tempMap.put("end", DateUtil.getDateFormat(carTimesDtlTemp.getBookDate())+" "+times[1]);//结束时间
				tempMap.put("allDay", false);//预留不能全天输出
				list.add(tempMap);
			}
		}
        jsonString=JSON.toJSONString(list); 
        log.debug(jsonString);  
        response.getWriter().print(jsonString);  
	}
	
}
