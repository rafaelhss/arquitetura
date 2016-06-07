/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.mvc.view;

import arquitetura.mvc.controller.Controller;
import arquitetura.mvc.model.Comissao;
import arquitetura.mvc.model.Venda;

/**
 *
 * @author rafa
 */
public class Visao {
    
    private Controller controller = new Controller();
    
    public String lucroTotal() {
       
        Venda v = new Venda();
        float cotacaoDollar = 3.8F;
        
        return "O lucro total ate agora foi R$" +  v.somatorioVendas() +  " (US$ " + (v.somatorioVendas()/cotacaoDollar) + ")";
    }
    
    public String comissaoVendedores() {
        Venda v = new Venda();
        
        Comissao c = controller.comissaoAtual();
        
        return "O total em comissao foi R$ " + c.calcularComissao(v.somatorioVendas());
    }
    
}
