/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.trescamadas;

import java.net.Socket;

/**
 *
 * @author rafa
 */
public class Apresentacao {
    
    private Negocio camadaNegocio = new Negocio();
    
    public String novaVenda(String produto, float valor){
        if (camadaNegocio.criarNovaVenda(produto, valor))
            return "Venda criada com sucesso!";
        else
            return "Erro ao criar venda";
    }
    
    public String lucroTotal() {
        float cotacaoDollar = 3.8F;
        float vendas = camadaNegocio.somatorioVendas();
        return "O lucro total ate agora foi R$" +  vendas +  " (US$ " + (vendas/cotacaoDollar) + ")";
    }
    
    public String comissaoVendedores() {
        float comissao = camadaNegocio.calculaComissao();
        return "O total em comissao foi R$ " + comissao;
    }
}
