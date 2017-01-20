import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Computer on 2017/1/20.
 */
public class try1 {
    public static void main(String[] args) throws Exception {
            try {
                Properties pro=new Properties();
                //类路径读取配置文件
                InputStream in =try1.class.getResourceAsStream("/jdbc.properties");
                pro.load(in);
                BasicDataSource b1= (BasicDataSource)BasicDataSourceFactory.createDataSource(pro);
                for(int i=0;i<10;i++) {
                    Connection c= b1.getConnection();
                    System.out.println(c);
            }
            } catch (Exception e) {
               e.printStackTrace();

        }
    }


}
