import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * Created by Computer on 2017/1/20.
 */
public class try2 {
    public static void main(String[] args) {
        ComboPooledDataSource combo= new ComboPooledDataSource();
        try {
              for(int i=0;i<11;i++){
                  Connection connection = combo.getConnection();
                  System.out.println(connection);
              }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
