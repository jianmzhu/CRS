package cn.crs.reserve.web;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import cn.crs.common.datatables.entity.DataTablesParam;
import cn.crs.common.datatables.entity.DataTablesUtil;
import cn.crs.common.pagination.BeanUtil;
import cn.crs.common.pagination.PagedResult;
import cn.crs.common.util.PageUtils;
import cn.crs.reserve.entity.SysUser;
import cn.crs.reserve.entity.SysUserExample;
import cn.crs.reserve.entity.SysUserExample.Criteria;
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
	@RequestMapping(value = "/getSysUser/list", method = RequestMethod.POST,  produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sysUserListByPaginator(@RequestBody Map<String,Object> pageJsonMap,HttpServletResponse response) {
		log.debug("分页查询用户信息列表请求入参：pageJsonMap{}", pageJsonMap);

		Map<String, Object> extraData = doPage(pageJsonMap);
		
		SysUserExample sysUserExample = new SysUserExample();
		//测试使用
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUserIdBetween(10000, 10500);
		
		try {
			PagedResult<SysUser> pageResult = BeanUtil.toPagedResult(sysUserService.selectByExample(sysUserExample));
//			PagedResult<SysUserPaginationSimple> pageResult = sysUserPaginationSimpleService.queryByPageOffset(userName, pageStart,pageSize);
//			PagedResult<SysUser> pageResult = sysUserService.selectByExampleAndOffsetPage(sysUserExample, pageStart, pageSize);
			return responseDataTablesSuccess(pageResult, extraData);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}

	private Map<String, Object> doPage(Map<String, Object> pageJsonMap) {
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
