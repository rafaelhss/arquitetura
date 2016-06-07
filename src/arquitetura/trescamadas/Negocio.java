/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.trescamadas;

import java.util.List;

/**
 *
 * @author rafa
 */
public class Negocio {
    
    private Dados fonteDeDados = new Dados();
    
    private float buscaAliquotaICMS(){
        return fonteDeDados.aliquota("ICMS");
    }
    
    public boolean criarNovaVenda(String produto, float valor){
        float novoValor = valor * (1- buscaAliquotaICMS());
        String novoValorStr = Float.toString(novoValor);
        return fonteDeDados.inserirVenda(produto, novoValorStr);
    }
    
    public float somatorioVendas(){
        List<String> vendas = fonteDeDados.listarVendas();
        
        float soma = 0;
        for (String vendaStr : vendas) {
            float venda = Float.parseFloat(vendaStr);
            
            soma += venda;          
        }
        
        return soma;
    }
    
    private float buscaComissao(){
        return fonteDeDados.comissaoFuncionarios();
    }
    
    public float calculaComissao(){
        return somatorioVendas() * buscaComissao();
    }
}
