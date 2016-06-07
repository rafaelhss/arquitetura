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
public class Imposto {
    
    private String nome;
    
    public Imposto(String nome){
        this.nome = nome;
    }
    
    
    public float aliquota(){
        if (nome.equals("ICMS"))
            return 0.14F;
        else
            return 0.2F;
    }
}
