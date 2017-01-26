package dao;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Computer on 2017/1/26.
 */
public class try1 {
    public static void main(String[] args) throws Exception{
        BufferedReader b=new BufferedReader(new FileReader("e:/J1.txt"));
        BufferedReader br=new MyBufferedReader(b);
        String s=null;
        while ((s=br.readLine())!=null){
            System.out.println(s );
        }
    }

}
