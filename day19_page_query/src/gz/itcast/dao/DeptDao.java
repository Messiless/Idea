package gz.itcast.dao;

import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;
import gz.itcast.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DeptDao {

	/**
	 * 查询所有部门
	 */
	public List<Department> findAll(){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "select * from department";
			List<Department> list = (List<Department>)qr.query(sql, new BeanListHandler(Department.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据条件查询部门
	 * @param args
	 */
	public List<Department> findByCondition(DeptQuery query){
		try {
			//根据查询条件拼凑一条sql语句
			StringBuffer sql = new StringBuffer("select * from department where 1=1 ");
			if(query!=null){
				//部门名称不为空，则往sql添加条件(trim():去掉两边空格)
				if(query.getDeptName()!=null && !query.getDeptName().trim().equals("")){
					sql.append(" and deptName like '%"+query.getDeptName()+"%'");
				}
				//负责人
				if(query.getPrincipal()!=null && !query.getPrincipal().trim().equals("")){
					sql.append(" and principal like '%"+query.getPrincipal()+"%'");
				}
				//职能
				if(query.getFunctional()!=null && !query.getFunctional().trim().equals("")){
					sql.append(" and functional like '%"+query.getFunctional()+"%'");
				}
			}
			System.out.println(sql.toString());
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Department>)qr.query(sql.toString(), new BeanListHandler(Department.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据id查询对应的部门对象
	 * @param args
	 */
	public Department findById(int id){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (Department)qr.query("select * from department where id=?", new BeanHandler(Department.class),new Object[]{id});
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		/*List<Department> list = dao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}*/
		DeptQuery query = new DeptQuery();
		//query.setDeptName("应用");
		//query.setPrincipal("李");
		query.setFunctional("aa");
		List<Department> list = dao.findByCondition(query);
		for (Department department : list) {
			System.out.println(department);
		}
	}
}
