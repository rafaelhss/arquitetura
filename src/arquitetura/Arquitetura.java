/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura;

import arquitetura.mvc.controller.Controller;
import arquitetura.mvc.util.BDUtil;
import arquitetura.mvc.view.Visao;
import arquitetura.trescamadas.Apresentacao;

/**
 *
 * @author rafa
 */
public class Arquitetura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //criarTabela();
        limparTabela();
        usarMVC();
       
        limparTabela();
        usar3Camadas();
    }

    private static void usar3Camadas() {
        Apresentacao apresentacao = new Apresentacao();
        
        System.out.println(apresentacao.novaVenda("batata", 30));
        System.out.println(apresentacao.novaVenda("banana", 20));
        System.out.println(apresentacao.novaVenda("repolho", 10));
        System.out.println(apresentacao.novaVenda("pneu", 10));
        
        System.out.println(apresentacao.lucroTotal());
        System.out.println(apresentacao.comissaoVendedores());
        
        
    }

    private static void criarTabela() {
        String query = "CREATE TABLE VENDAS( NOME VARCHAR(250), VALOR VARCHAR (250))";
        BDUtil.executarSQL(query); 
    }
    private static void limparTabela() {
        String query = "DELETE FROM VENDAS";
        BDUtil.executarSQL(query); 
    }

    private static void usarMVC() {
        
        Controller controller = new Controller();
        controller.incluirVenda("batata", 30);
        controller.incluirVenda("banana", 20);
        controller.incluirVenda("repolho", 10);
        controller.incluirVenda("pneu", 10);
        
        
        Visao visao = new Visao();
        System.out.println(visao.lucroTotal());
        System.out.println(visao.comissaoVendedores());
        
        
        
    }
    
}
