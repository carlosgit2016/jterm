package jterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Write a description of class ComandoPrompt here.
 *
 * @author GOIANI, PANIZIO , ALEXSSANDRO
 * @version 1.0
 */
public class ComandoPrompt {
    
    public ComandoPrompt(String comando) {
        
        String valoresComandos[] = comando.split(" ");
        this.nome = valoresComandos[0];
        
        if(valoresComandos.length > 1){
            this.argumentos = new String[valoresComandos.length -1];
            for(int i = 1; i < valoresComandos.length;i++){
                this.argumentos[i-1] = valoresComandos[i];
            }
        }else{
            this.argumentos = new String[1];
            this.argumentos[0] = "@#vazio#@";
        }
        
    }
    
    
    /**
     * Método acessor get para o nome do comando.
     * 
     * @return o nome do comando, exatamente como foi entrado.
     */
    public String getNome() { 
        return nome;
    }
    
    /**
     * Método acessor get para os argumentos que seguem o nome do comando.
     * 
     * @return Lista de argumentos do comando, protegida contra modificações externas.
     */
    public List<String> getArgumentos() {
        return Collections.unmodifiableList(Arrays.asList(argumentos));
    }
    
    private final String nome;
    private final String[] argumentos;
    //private final ArrayList<String> argumentos;
}
