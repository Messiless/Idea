package dao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Computer on 2017/1/26.
 */
public class MyBufferedReader extends BufferedReader {
        private BufferedReader br;
    public MyBufferedReader(BufferedReader in) {
        super(in);
         this.br=in;
    }
int i=1;
    @Override
    public String readLine() throws IOException {
        String com=br.readLine();
        if(com!=null){
            com=i+":"+com;
            i++;
        }
        return com ;
    }
}
