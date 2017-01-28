package web;

import java.io.IOException;

/**
 * Created by Computer on 2017/1/25.
 */
@javax.servlet.annotation.WebServlet(name = "TargetServlet")
public class TargetServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doGet(request,response);
    }
//just a contribute
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("shuaibi");
    }
}
