/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.mvc.model;

import arquitetura.mvc.util.BDUtil;
import java.util.List;

/**
 *
 * @author rafa
 */
public class Venda {
    private String nome;
    private float valor;
    
    public Venda(){
        
    }
    
    public Venda(String nome, float valor){
        this.nome = nome;
        this.valor = valor;
        String query = "INSERT INTO VENDAS VALUES('"+ nome +"','"+ valor +"')";
        
        BDUtil.executarSQL(query);
    }
    
    public float somatorioVendas(){
        String query = "SELECT VALOR FROM VENDAS";
        
        List<String> vendas = BDUtil.executarSQLComRetorno(query);
        
        float soma = 0;
        for (String vendaStr : vendas) {
            float venda = Float.parseFloat(vendaStr);
            
            soma += venda;          
        }
        
        return soma;
    }
    
    
}
