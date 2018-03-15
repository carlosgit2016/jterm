package jterm;

import java.util.Optional;
import java.util.Scanner;


/**
 * Write a description of class JTerm here.
 *
 * @author GOIANI, PANIZIO , ALEXSSANDRO
 * @version 1.0
 */
public final class JTerm {
    
    /**
    * Funcao principal do UniTerm.
    */
    public static void promptTerminal() {
        while (true) {
    		exibirPrompt();
    		ComandoPrompt entrado = lerComando();
    		executarComando(entrado);
    	}
    }

    /**
    * Escreve o prompt na saida padrao para o usuário reconhecê-lo e saber que o
    * terminal está pronto para receber o próximo comando como entrada.
    */
    public static void exibirPrompt() {
        String UUID = ComandosInternos.getUID();
        String login = ComandosInternos.getUser();
        String diretorioAtual = ComandosInternos.getDiretorioAtual();
       
        System.out.print(UUID + ":" + login + "@" + diretorioAtual + "> ");
    }

    /**
    * Preenche as strings comando e parametros com a entrada do usuario do terminal.
    * A primeira palavra digitada eh sempre o nome do comando desejado. Quaisquer
    * outras palavras subsequentes sao parametros para o comando. A palavras sao
    * separadas pelo caractere de espaco ' '. A leitura de um comando eh feita ate
    * que o usuario pressione a tecla <ENTER>, ou seja, ate que seja lido o caractere
    * EOL (End Of Line).
    *
    * @return 
    */
    public static ComandoPrompt lerComando() {
        Scanner input = new Scanner(System.in);
        String comando = input.nextLine();
        return new ComandoPrompt(comando);
    }

    /**
    * Recebe o comando lido e os parametros, verifica se eh um comando interno e,
    * se for, o executa.
    * 
    * Se nao for, verifica se é o nome de um programa terceiro localizado no atual 
    * diretorio de trabalho. Se for, cria um novo processo e o executa. Enquanto
    * esse processo executa, o processo do uniterm deve permanecer em espera.
    *
    * Se nao for nenhuma das situacoes anteriores, exibe uma mensagem de comando ou
    * programa desconhecido.
    */
    public static void executarComando(ComandoPrompt comando) {       
        String argumento  = comando.getArgumentos().get(0);
        String nome = comando.getNome();
        
        switch(nome){
            case "sair" :
                ComandosInternos.sair();
                break;
            case "datahora" :
                ComandosInternos.exibirDataHora();
                break;
            case "listar" : 
                ComandosInternos.listarArquivos(Optional.ofNullable(argumento));
                break;
            case "nd" :
                ComandosInternos.criarNovoDiretorio(argumento);
                break;
            case "rd" :
                ComandosInternos.apagarDiretorio(argumento);
                break;
            case "td" :
                ComandosInternos.trocarDiretorioTrabalho(argumento);
                break;
            case "ajuda" :
                ComandosInternos.ajuda();
                break;
            default :
                executarPrograma(comando);
                break;
        }
        
    }

    public static void executarPrograma(ComandoPrompt comando) {
        String nome = comando.getNome();
        if(ComandosInternos.arquivoExiste(nome)){
            if(ComandosInternos.arquivoPodeSerExecutado(nome)){
                ComandosInternos.executarPrograma(nome);
            }else{
                System.out.println(
                        "Arquivo '"+nome+"' não tem permissão para execução");
            }
        }else{
            System.out.println(
                    "Comando ou Programa '" + nome + "' inexistente");
        }
        
    }
    
    /**
     * Entrada do programa. Provavelmente você não precisará modificar esse método.
     */
    public static void main(String[] args) {
        promptTerminal();
    }
    
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private JTerm() {}
}
