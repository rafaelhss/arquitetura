/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.mvc.controller;

import arquitetura.mvc.model.Comissao;
import arquitetura.mvc.model.Imposto;
import arquitetura.mvc.model.Venda;

/**
 *
 * @author rafa
 */
public class Controller {
    public Venda incluirVenda(String produto, float valor){
        Imposto i = new Imposto("ICMS");
        float novoValor = valor * (1-i.aliquota());
        Venda v = new Venda(produto,novoValor);
        return v;
    }
    
    public Comissao comissaoAtual(){
        return new Comissao(0.02F);
    }
}
