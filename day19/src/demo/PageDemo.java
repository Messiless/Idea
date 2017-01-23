package demo;

import entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUitl;

import java.util.List;

/**
 * Created by Computer on 2017/1/23.
 */
        public class PageDemo {

            public List<Employee> getPageEm(int Count, int every){
                try {
                    QueryRunner qur = new QueryRunner(JdbcUitl.getDataSource());
                    String sql="SELECT*FROM just5 LIMIT ?,?";
                    int  k1=(Count-1)*every;
                    List<Employee> lis=(List<Employee>)qur.query(sql, new BeanListHandler(Employee.class), new Object[]{k1,every });
                    return lis;
                }
                catch (Exception e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
    }
    public int getCounts(){
        try {
            QueryRunner qur = new QueryRunner(JdbcUitl.getDataSource());
            String sql = "select count(*) from just5";
            Long l = (Long) qur.query(sql, new ScalarHandler(), new Object[]{});
            return l.intValue();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
