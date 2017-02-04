package gz.itcast.service;

import gz.itcast.dao.EmpDao;
import gz.itcast.entity.EmpQuery;
import gz.itcast.entity.Employee;
import gz.itcast.entity.PageBean;

import java.util.List;

/**
 * Ա����service��
 * 
 * @author APPle
 * 
 */
public class EmpService {
	EmpDao empDao = new EmpDao();

	/**
	 * �ṩһ����װ�õ�PageBean����
	 * @return
	 */
	public PageBean queryPageBean(Integer currentPage,int pageSize,EmpQuery query) {
		/***********1)��װPageBeanҵ�����   ***************/
		PageBean pageBean = new PageBean();

		// 1.3 ���û������л�ȡ��ǰҳ����(currentPage)
		pageBean.setCurrentPage(currentPage);

		// �����ݿ��ж�ȡ�ܼ�¼��
		int count = empDao.queryCount(query);
		// 1.4 �ܼ�¼��
		pageBean.setTotalCount(count);

		// 1.5 ÿҳ��ʾ��¼��
		pageBean.setPageSize(pageSize);

		// �����ݿ��ж�ȡ��ǰҳ����
		List<Employee> list = empDao.queryData(pageBean.getCurrentPage(),
				pageBean.getPageSize(),query);
		pageBean.setData(list);
		
		return pageBean;
	}
}
