package util;


import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Computer on 2017/1/21.
 */
public class BeanUtil {
    public static <T> T getBean(HttpServletRequest request, Class<T> clazz) {
        try {
            Map map = request.getParameterMap();

            T t = clazz.newInstance();
            BeanUtils.copyProperties(t, map);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}