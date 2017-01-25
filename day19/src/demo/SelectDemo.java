package demo;

import entity.SelectWorker;
import entity.Work;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUitl;

import java.util.List;

/**
 * Created by Computer on 2017/1/25.
 */
public class SelectDemo {
    public List<Work> getSelect(SelectWorker so){
        try{
            StringBuffer str=new StringBuffer("SELECT*FROM just5_dept WHERE 1=1");
            if(so!=null){
                if(so.getDeptname()!=null&&!so.getDeptname().trim().equals("")){
                    str.append("AND deptname like '%"+so.getDeptname()+"%'");
                }
                if(so.getPrin()!=null&&!so.getPrin().trim().equals("")){
                    str.append("AND prin like '%"+so.getPrin()+"%'");
                }
                if(so.getFunction()!=null&&!so.getFunction().trim().equals("")){
                    str.append("AND function like '%"+so.getFunction()+"%'");
                }
            }


            QueryRunner qur =new QueryRunner(JdbcUitl.getDataSource());
            List<Work> list=(List<Work>)qur.query(str.toString(),new BeanListHandler(Work.class),new Object[]{} );
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
