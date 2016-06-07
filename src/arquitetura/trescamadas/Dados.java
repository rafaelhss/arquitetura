/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.trescamadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa
 */
public class Dados {
    
    
    public float aliquota(String nomeImposto){
        if (nomeImposto.equals("ICMS"))
            return 0.14F;
        else
            return 0.2F;
    }
    
    public float comissaoFuncionarios(){
        return 0.01F;
    }
    
    
    public List<String> listarVendas(){
        String query = "SELECT VALOR FROM VENDAS";
        return executarSQLComRetorno(query);        
        
    }
    
    
    public boolean inserirVenda(String nome, String valor){
        String query = "INSERT INTO VENDAS VALUES('"+ nome +"','"+ valor +"')";
            
        return executarSQL(query);
    }
    
    private List<String> executarSQLComRetorno(String sql) {
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
    
    private boolean executarSQL(String sql) {
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
