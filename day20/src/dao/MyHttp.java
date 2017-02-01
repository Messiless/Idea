package dao;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Computer on 2017/1/27.
 */
public class MyHttp extends HttpServletResponse {
    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }
}
