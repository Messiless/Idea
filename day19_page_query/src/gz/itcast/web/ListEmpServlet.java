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
		
		//接收用户输入的条件
		EmpQuery query = WebUtil.copyRequestToBean(request, EmpQuery.class);
		
		/****  1）接收用户输入的参数 ： currentPage参数   ****/
		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			// 如果用户第一次访问，没有传递currentPage参数，则当前页为1
			currentPage = "1";
		}
		//接收用户输入的每页显示记录数
		String pageSize = request.getParameter("pageSize");
		//如果没有传递这个pageSize参数，则为默认值5
		if(pageSize==null || pageSize.equals("")){
			pageSize = "5";
		}
		
		/*******2)调用业务逻辑方法，获取结果    *****************/
		//1)封装PageBean对象
		EmpService service = new EmpService();
		PageBean pageBean = service.queryPageBean(Integer.parseInt(currentPage),Integer.parseInt(pageSize),query);

		/********3)把结果转发到jsp页面显示   *********************/
		//2)把PageBean对象放入域对象中
		request.setAttribute("pageBean", pageBean);
		//查询所有部门，转发到jsp页面
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		
		//3)转发到jsp页面显示数据
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
