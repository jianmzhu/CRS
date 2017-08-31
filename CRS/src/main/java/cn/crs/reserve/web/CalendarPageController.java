package cn.crs.reserve.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
}
