package cn.crs.common.util.blockThreadPool;

/**
 * Created by zengyufei on 2016/11/25.
 */
public interface ObjectFactory<T> {

	T create();
}
