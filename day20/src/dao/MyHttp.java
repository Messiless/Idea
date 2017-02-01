package dao;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Computer on 2017/1/27.
 */
public class MyHttp extends HttpServletResponseWrapper{
    private HttpServletResponse response;
    private CharArrayWriter charArrayWriter=new CharArrayWriter();
    public char[] getCharArray(){
        return charArrayWriter.toCharArray();
    }
    public MyHttp(HttpServletResponse response) {
        super(response);
        this.response=response;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(charArrayWriter);
    }
}
