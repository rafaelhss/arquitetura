/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arquitetura.mvc.model;

/**
 *
 * @author rafa
 */
public class Comissao {
    private float taxa;
    
    public Comissao(float taxa){
        this.taxa = taxa;
    }
    
    public float calcularComissao(float venda){
        return venda * taxa;
    }
    
}
