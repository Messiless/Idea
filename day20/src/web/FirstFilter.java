package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Computer on 2017/2/2.
 */
@WebFilter(filterName = "FirstFilter",urlPatterns ="/User.jsp")
public class FirstFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse)resp;
        HttpSession h = httpServletRequest.getSession(false);
        if (h == null) {
            httpServletRequest.getRequestDispatcher("/no.html").forward(httpServletRequest, httpServletResponse);
            return;
        } else {
            String s = (String) h.getAttribute("user");
            if (s == null) {
                httpServletRequest.getRequestDispatcher("/no.html").forward(httpServletRequest, httpServletResponse);
                return;
            }

        }
        chain.doFilter(httpServletRequest, httpServletResponse);
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
