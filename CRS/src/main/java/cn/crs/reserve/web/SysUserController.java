package cn.crs.reserve.web;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.crs.common.PageUtils;
import cn.crs.common.datatables.entity.DataTablesParam;
import cn.crs.common.datatables.entity.DataTablesUtil;
import cn.crs.common.pagination.PagedResult;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.entity.SysUserExample;
import cn.crs.reserve.entity.SysUserExample.Criteria;
import cn.crs.reserve.entity.SysUserPaginationSimple;
import cn.crs.reserve.service.SysUserPaginationSimpleService;
import cn.crs.reserve.service.SysUserService;

/**
 * 
 * @author ZJM
 *
 * @date 2017年6月2日
 */
@Controller
public class SysUserController extends JsonBaseController{

	private static Logger log = LoggerFactory
			.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;
//	@Autowired
//	private SysUserPaginationSimpleService sysUserPaginationSimpleService;
	@Autowired
	private PageUtils pageUtils;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private HttpServletResponse httpServletResponse;

	/**
	 * 用户分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sysUserListPage/{page}")
	public String sysUserListByPaged(Model model, @PathVariable("page") int page) {
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(sysUserService.countSysUserByTypeNum());
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord()
					* (pageUtils.getCurrentPage() - 1);
		}
		// 分页查询用户信息
		List<SysUser> users = sysUserService.findSysUserByType(start,
				pageUtils.getPageRecord());
		model.addAttribute("users", users);
		model.addAttribute("pages", pageUtils);
		return "notice/noticeIndex";
	}

	/**
	 * 用户信息详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sysUserInfo/{id}", method = RequestMethod.GET)
	public String sysUserInfoShow(Model model,
			@PathVariable(value = "id") int id) {
		SysUser sysUser = sysUserService.getUserInfoById(id);
		model.addAttribute("sysUser", sysUser);
		return "sysUser/userInfo";
	}

	/**
	 * 项目跳转到 用户记录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/AllSysUser", method = RequestMethod.GET)
	public String sysUserList(Model model) {
		// 查询所有通知
//		List<SysUser> users = sysUserService.getAllUserList();
//		model.addAttribute("users", users);
		return "userInfo/sysUserList";
	}

	/**
     * 分页查询用户信息（ajax的post请求）
     * @param page
     * @return
     */
	@RequestMapping(value = "/getSysUser/list", method = RequestMethod.POST)
	@ResponseBody
	public String sysUserListByPaginator(@RequestBody Map<String,Object> pageJsonMap) {
		log.debug("分页查询用户信息列表请求入参：pageJsonMap{}", pageJsonMap);
		
		Integer draw = Integer.parseInt(pageJsonMap.get("sEcho")+"");
		Integer pageStart = Integer.parseInt(pageJsonMap.get("iDisplayStart")+"");//查询第几条
		Integer pageSize = Integer.parseInt(pageJsonMap.get("iDisplayLength")+"");//每页长度
		Integer pageNumber = (pageStart + 1)/pageSize + 1;//页数
		DataTablesParam dataTablesParam = null;
		try {
			dataTablesParam = DataTablesUtil.getInstance().createDataTablesParam(pageJsonMap);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IntrospectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		log.debug("处理后，页面参数为：pageStart{},pageSize{}", pageStart,pageSize);
		log.debug("处理后，页面参数为：pageNumber{}", pageNumber);
		
		SysUserExample sysUserExample = new SysUserExample();
		if(dataTablesParam!=null){
			log.debug("dataTablesParam对象为：" + dataTablesParam.toString());
			String orderByClause = DataTablesUtil.getOrderByClause(dataTablesParam);
			log.debug("orderByClause为：" + orderByClause);
			sysUserExample.setOrderByClause(orderByClause);
		}
		Map<String,Object> extraData = new HashMap<String,Object>();
		extraData.put("draw", draw);
		
		try {
//			PagedResult<SysUserPaginationSimple> pageResult = sysUserPaginationSimpleService.queryByPageOffset(userName, pageStart,pageSize);
			PagedResult<SysUser> pageResult = sysUserService.selectByExampleAndOffsetPage(sysUserExample, pageStart, pageSize);
			return responseDataTablesSuccess(pageResult, extraData);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}

}
