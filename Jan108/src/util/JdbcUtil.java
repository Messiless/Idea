package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Computer on 2017/1/9.
 */
public class JdbcUtil {
    private static String url=null;
    private static String user=null;
    private static String password=null;
    private static String DriverClass=null;
    static{try {
        Properties pr=new Properties();
        InputStream in=JdbcUtil.class.getResourceAsStream("./jdbc.properties");
        pr.load(in);
        url=pr.getProperty("url");
        user=pr.getProperty("user");
        password=pr.getProperty("password");
        DriverClass=pr.getProperty("DriverClass");
        Class.forName(DriverClass);
    } catch (Exception e) {

    }

    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    public static void show(ResultSet res, Statement sta, Connection con){
        if(res!=null){
            try {
                res.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        if(sta!=null){
            try {
                sta.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
    public static void show(Statement sta,Connection con){
        if(sta!=null){
            try {
                sta.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
