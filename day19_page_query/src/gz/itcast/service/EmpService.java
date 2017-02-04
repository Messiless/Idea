package gz.itcast.service;

import gz.itcast.dao.EmpDao;
import gz.itcast.entity.EmpQuery;
import gz.itcast.entity.Employee;
import gz.itcast.entity.PageBean;

import java.util.List;

/**
 * 员工的service类
 * 
 * @author APPle
 * 
 */
public class EmpService {
	EmpDao empDao = new EmpDao();

	/**
	 * 提供一个封装好的PageBean对象
	 * @return
	 */
	public PageBean queryPageBean(Integer currentPage,int pageSize,EmpQuery query) {
		/***********1)封装PageBean业务对象   ***************/
		PageBean pageBean = new PageBean();

		// 1.3 从用户参数中获取当前页数据(currentPage)
		pageBean.setCurrentPage(currentPage);

		// 从数据库中读取总记录数
		int count = empDao.queryCount(query);
		// 1.4 总记录数
		pageBean.setTotalCount(count);

		// 1.5 每页显示记录数
		pageBean.setPageSize(pageSize);

		// 从数据库中读取当前页数据
		List<Employee> list = empDao.queryData(pageBean.getCurrentPage(),
				pageBean.getPageSize(),query);
		pageBean.setData(list);
		
		return pageBean;
	}
}
