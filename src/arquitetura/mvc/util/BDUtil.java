/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa
 */
public class BDUtil {
        public static List<String> executarSQLComRetorno(String sql) {
        List<String> result = new ArrayList<String>();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            java.sql.Statement transacao = con.createStatement();
            
            ResultSet res = transacao.executeQuery(sql);
            
            while(res.next()){
                result.add(res.getString(1));
            }
            
            transacao.close();
            con.close();
        } catch( Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
    
    public static boolean executarSQL(String sql) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app", "app");
            java.sql.Statement transacao = con.createStatement();
            
            transacao.executeUpdate(sql);

            transacao.close();
            con.close();
        } catch( Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
