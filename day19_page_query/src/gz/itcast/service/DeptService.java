package gz.itcast.service;

import gz.itcast.dao.DeptDao;
import gz.itcast.entity.Department;
import gz.itcast.entity.DeptQuery;

import java.util.List;
/**
 * 部门的service类
 * @author APPle
 *
 */
public class DeptService {
	DeptDao deptDao = new DeptDao();
	
	public List<Department> findAll(){
		return deptDao.findAll();
	}
	
	public List<Department> findByCondition(DeptQuery query){
		return deptDao.findByCondition(query);
	}
}

