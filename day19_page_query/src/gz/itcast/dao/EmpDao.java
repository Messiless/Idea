package gz.itcast.dao;

import gz.itcast.entity.Department;
import gz.itcast.entity.EmpQuery;
import gz.itcast.entity.Employee;
import gz.itcast.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 员工的dao
 * @author APPle
 *
 */
public class EmpDao {

	DeptDao deptDao = new DeptDao();
	/**
	 * 提供一个查询当前页员工数据的方法
	 */
	public List<Employee> queryData(int currentPage,int pageSize,EmpQuery query){
		try {
			//1)创建QueryRunner
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			//分页+条件查询的sql
			
			StringBuffer sql = new StringBuffer("select * from employee where 1=1 ");
			if(query!=null){
				if(query.getName()!=null && !query.getName().trim().equals("")){
					sql.append(" and name like '%"+query.getName()+"%'");
				}
				if(query.getGender()!=null && !query.getGender().trim().equals("")){
					sql.append(" and gender='"+query.getGender()+"'");
				}
				if(query.getTitle()!=null && !query.getTitle().trim().equals("")){
					sql.append(" and title like '%"+query.getTitle()+"%'");
				}
				if(query.getEmail()!=null && !query.getEmail().trim().equals("")){
					sql.append(" and email like '%"+query.getEmail()+"%'");
				}
				//如果起始薪水值不为空，则查询的结果应该大于起始薪水值
				if(query.getBeginSalary()!=0){
					sql.append(" and salary>='"+query.getBeginSalary()+"'");
				}
				if(query.getEndSalary()!=0){
					sql.append(" and salary<='"+query.getEndSalary()+"'");
				}
				//部门id
				if(query.getDeptId()!=0){
					sql.append(" and deptId="+query.getDeptId()+"");
				}
			}
			//分页
			sql.append(" limit ?,?");
			System.out.println(sql.toString());
			
				
			//起始行
			int startNo =  (currentPage-1)*pageSize;
			List<Employee> list = (List<Employee>)qr.query(sql.toString(), new MyEmpResultSetHandler(), new Object[]{startNo,pageSize});
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 自行封装结果集
	 */
	class MyEmpResultSetHandler implements ResultSetHandler{

		public Object handle(ResultSet rs) throws SQLException {
			List<Employee> list = new ArrayList<Employee>();
		
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setGender(rs.getString("gender"));
				emp.setTitle(rs.getString("title"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));
				
				//部门id
				int deptId = rs.getInt("deptId");
				//根据id查询部门对象
				Department dept = deptDao.findById(deptId);
				emp.setDept(dept);
				
				list.add(emp);
			}
			return list;
		}
		
	}
	
	/**
	 * 提供一个查询总记录数的方法
	 * @param args
	 */
	public int queryCount(EmpQuery query){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			StringBuffer sql = new StringBuffer("select count(*) from employee where 1=1 ");
			if(query!=null){
				if(query.getName()!=null && !query.getName().trim().equals("")){
					sql.append(" and name like '%"+query.getName()+"%'");
				}
				if(query.getGender()!=null && !query.getGender().trim().equals("")){
					sql.append(" and gender='"+query.getGender()+"'");
				}
				if(query.getTitle()!=null && !query.getTitle().trim().equals("")){
					sql.append(" and title like '%"+query.getTitle()+"%'");
				}
				if(query.getEmail()!=null && !query.getEmail().trim().equals("")){
					sql.append(" and email like '%"+query.getEmail()+"%'");
				}
				//如果起始薪水值不为空，则查询的结果应该大于起始薪水值
				if(query.getBeginSalary()!=0){
					sql.append(" and salary>='"+query.getBeginSalary()+"'");
				}
				if(query.getEndSalary()!=0){
					sql.append(" and salary<='"+query.getEndSalary()+"'");
				}
				//部门id
				if(query.getDeptId()!=0){
					sql.append(" and deptId="+query.getDeptId()+"");
				}
			}
			System.out.println(sql.toString());
			Long count = (Long)qr.query(sql.toString(), new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		/*List<Employee> list = dao.queryData(4, 2);
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		
		/*int count = dao.queryCount();
		System.out.println(count);*/
		
		EmpQuery query = new EmpQuery();
		query.setName("1");
		/*query.setName("1");
		List<Employee> list = dao.queryData(1, 2, query);
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		
		int count = dao.queryCount(query);
		System.out.println(count);
	}
}
