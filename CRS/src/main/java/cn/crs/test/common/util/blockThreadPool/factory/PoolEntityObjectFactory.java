package cn.crs.test.common.util.blockThreadPool.factory;

import cn.crs.common.util.blockThreadPool.ObjectFactory;
import cn.crs.reserve.entity.SysUser;


public class PoolEntityObjectFactory implements ObjectFactory {

		@Override
		public Object create() {
			return new SysUser();
		}
	}