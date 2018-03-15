/**
 * Contém o conteudo em String de ajuda aos comandos existentes no terminal
 */
package jterm;

/**
 *
 * @author GOIANI, PANIZIO , ALEXSSANDRO
 * @version 1.0
 * 
 */
public class AjudaComandos {
    
    private String ajuda;
    
    public AjudaComandos(){
        ajuda = "\nsair - Termina o programa retornando 0\n" + 
                "datahora - exibe a data e a hora atual do sistema\n"+
                "listar - lista os nome de todos dos arquivos e diretórios do atual diretório de trabalho.\n"+
                "nd - cria um novo diretório\n"+
                "rd - Apaga o diretorio especificado\n" + 
                "td - Troca o diretorio de trabalho pelo especificado.\n ";
    }
    
    public String getAjuda(){
        return ajuda;
    }
    
}
