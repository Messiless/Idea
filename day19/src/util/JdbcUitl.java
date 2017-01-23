package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * Created by Computer on 2017/1/23.
 */
public class JdbcUitl {
    private static DataSource data=new ComboPooledDataSource();
    public static DataSource getDataSource(){
     return  data;
    }
}
