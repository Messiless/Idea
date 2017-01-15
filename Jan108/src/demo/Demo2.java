package demo;

import java.io.*;

/**
 * Created by Computer on 2017/1/14.
 */
public class Demo2 {
    public static void main(String[] args) {

        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer=new BufferedWriter(new FileWriter("e:\\t11.txt"));
            String s=null;
            while((s=reader.readLine())!=null){
                writer.write(s);
            }
          reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
