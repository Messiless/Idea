package web;

import entity.PageBean;
import service.PageService;

import java.io.IOException;


/**
 * Created by Computer on 2017/1/23.
 */
public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //当前页
        String checkPage=request.getParameter("checkPage");
        if(checkPage==null ||checkPage.equals("")){
         checkPage="1";
        }
        int c1=Integer.parseInt(checkPage);
        PageService pa=new PageService();
        PageBean pageBean=pa.getPageBean(c1,3 );
         request.setAttribute("pageBean",pageBean);

        request.getRequestDispatcher("/PageTry.jsp").forward(request,response);

    }
}
