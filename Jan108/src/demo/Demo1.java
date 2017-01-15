





package demo;



import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Computer on 2017/1/8.669+++++
 *
 *
 * 3
 */
//事物
public class Demo1{
    public static void main(String[] args) {
                Connection con=null;
                PreparedStatement stm=null;

        try {

           con = JdbcUtil.getConnection();
            con.setAutoCommit(false);
            String sql1="UPDATE  just3 SET money=money+2000 where name='汪梓成'";
            String sql2="UPDATE  just3 SET money=money-2000 where name='张三'";
            stm=con.prepareStatement(sql1);
            stm.executeUpdate();
            int i=1/0;
            stm=con.prepareStatement(sql2);
            stm.executeUpdate();
            con.commit();
            System.out.println("打印成功");
        }
        catch(Exception e){
            System.out.println("回滚");
            try {
                con.rollback();
            }
            catch (Exception w){
                System.out.println("中间出错，回滚完毕");
            }
        }
        finally {
            JdbcUtil.show(stm,con);
        }
    }
}














