package gz.itcast.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static <T> T copyRequestToBean(HttpServletRequest request,Class<T> clazz){
		/**
		 * 把request对象中的参数，逐个封装到javabean（Contact）对象中
		 */
		//1)得到request的所有参数
		/**
		 * <key,value>
		 * 		<参数名称，String[]> 
		 */
		try {
			Map map = request.getParameterMap();
			//构造对象
			T t = clazz.newInstance();
			//约定前提： 参数名称和javabean的属性名称保持一致！！！！
			BeanUtils.copyProperties(t, map);
			return t;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		
	}
}
