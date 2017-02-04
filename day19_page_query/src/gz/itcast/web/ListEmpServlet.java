package gz.itcast.web;

import gz.itcast.dao.EmpDao;
import gz.itcast.entity.Department;
import gz.itcast.entity.EmpQuery;
import gz.itcast.entity.Employee;
import gz.itcast.entity.PageBean;
import gz.itcast.service.DeptService;
import gz.itcast.service.EmpService;
import gz.itcast.util.WebUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DeptService deptService = new DeptService();
		
		
		//t1(request, response);
		
		
		//t2(request, response);
		
		//�����û����������
		EmpQuery query = WebUtil.copyRequestToBean(request, EmpQuery.class);
		
		/****  1�������û�����Ĳ��� �� currentPage����   ****/
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			// ����û���һ�η��ʣ�û�д���currentPage��������ǰҳΪ1
			currentPage = "1";
		}
		//�����û������ÿҳ��ʾ��¼��
		String pageSize = request.getParameter("pageSize");
		//���û�д������pageSize��������ΪĬ��ֵ5
		if(pageSize==null || pageSize.equals("")){
			pageSize = "5";
		}
		
		/*******2)����ҵ���߼���������ȡ���    *****************/
		//1)��װPageBean����
		EmpService service = new EmpService();
		PageBean pageBean = service.queryPageBean(Integer.parseInt(currentPage),Integer.parseInt(pageSize),query);

		/********3)�ѽ��ת����jspҳ����ʾ   *********************/
		//2)��PageBean��������������
		request.setAttribute("pageBean", pageBean);
		//��ѯ���в��ţ�ת����jspҳ��
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		
		//3)ת����jspҳ����ʾ����
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
