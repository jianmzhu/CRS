package cn.crs.test.reserve.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import cn.crs.reserve.web.IndexPageController;

public class IndexPageControllerOldTest {

	private IndexPageController indexPageController;

	@Before
	public void setUp() {
		indexPageController = new IndexPageController();
		// 安装userCtroller依赖 比如userService
	}

	@Test
	public void testView() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();
		MockHttpSession session = new MockHttpSession();
		String mv = indexPageController.redirectlogin(session);

		System.out.println(mv);

	}
}