package web;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Computer on 2017/1/25.
 */
@javax.servlet.annotation.WebServlet(name = "TargetServlet" ,urlPatterns = "/TargetServlet")
public class TargetServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    //just a contribute
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String t1 = request.getParameter("userName");
        String t2 = request.getParameter("password");
        if ("chengge1124".equals(t1) && "946971".equals(t2)) {
            HttpSession session= request.getSession(true);
            session.setAttribute("user",t1);
            response.sendRedirect("/User.jsp");
        } else {
            request.setAttribute("error","error");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}