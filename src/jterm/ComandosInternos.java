package jterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author GOIANI, PANIZIO , ALEXSSANDRO
 * @version 1.0
 */
public final class ComandosInternos {
    
    public static void exibirDataHora() {
        
        Date data = new Date();
        DateFormat formato = new SimpleDateFormat("'São' HH:mm 'de' dd/MM/YYYY");
        System.out.println(formato.format(data));
        
    }
    
    public static void listarArquivos(Optional<String> nomeDir) {
        
        try{
            
            File file;
            if(nomeDir.get().equals("@#vazio#@")){
                file = new File("").getAbsoluteFile();
            }else{
                file = new File(nomeDir.get());
            }
            for(String s : file.list()){
                System.out.println(s);
            }
            
        }catch(NullPointerException ex){
            System.out.print("");
        }
        
    }
    
    public static void criarNovoDiretorio(String nomeDir) {
        
        if(!nomeDir.equals("@#vazio#@")){
            
            File file = new File(nomeDir).getAbsoluteFile();
            try {
                file.mkdir();
            } catch (Exception e) {
                System.err.println("Erro ao criar arquivo");
            }
            
        }else{
            System.out.println("Defina o diretorio.");
        }
                
    }
    
    public static void apagarDiretorio(String nomeDir) {
        
        if(!nomeDir.equals("@#vazio#@")){
            
            File file = new File(nomeDir).getAbsoluteFile();
            try {
                if(file.exists())file.delete();
                else{System.out.println("Arquivo não existe.");};
            } catch (Exception e) {
                System.err.println("Erro ao criar arquivo");
            }
            
        }else{
            System.out.println("Defina o diretorio.");
        }
        
    }
    
    public static void trocarDiretorioTrabalho(String nomeDir){
        
        if(!nomeDir.equals("@#vazio#@")){
            
            File file = new File(nomeDir).getAbsoluteFile();
            try {
                if(file.getAbsoluteFile().exists()){
                    setDiretorioAtual(file.getAbsolutePath());
                }else{
                    System.out.println("Diretorio não existe.");
                }
            } catch (Exception e) {
                System.err.println("Erro ao navegar");
            }
            
        }else{
            System.out.println("Defina o diretorio.");
        }
    }
    
    public static void ajuda(){
        AjudaComandos ajuda  = new AjudaComandos();
        System.out.println(ajuda.getAjuda());
    }
    
    public static void sair(){
        System.exit(0);
    }
    
    public static String getUID(){
        try{
            
            String uid = "";
            Process processo = Runtime.getRuntime().exec("id -u");
            InputStream entradaSystem = processo.getInputStream();
            
            for(int num = entradaSystem.read() ; num != -1 ; num = entradaSystem.read()){
                uid+= (char)num;
            }
            
            entradaSystem.close();
            return uid.replace("\n", "");
            
        }catch(Exception ex){
            return "Erro ao obter UID";
        }
        
    }
    
    public static String getUser(){
        return System.getProperty("user.name");
    }
    
    public static String getDiretorioAtual(){
        return System.getProperty("user.dir");
    }
    
    public static void setDiretorioAtual(String caminho){
        System.setProperty("user.dir", caminho);
    }
    
    public static boolean arquivoExiste(String caminho){
        File file = new File(caminho).getAbsoluteFile();
        return file.exists();
    }
    
     public static boolean arquivoPodeSerExecutado(String caminho){
        File file = new File(caminho).getAbsoluteFile();
        return file.canExecute();
    }
    
    public static void executarPrograma(String caminho){
        File file = new File(caminho);
        ProcessBuilder processB = new ProcessBuilder(file.getAbsolutePath());
        try {
            Process process = processB.start();
            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String out;
            while ((out = buffer.readLine()) != null) {
                System.out.println(out);
            }
            
            if(testeProcesso(process) != 0){
                System.out.println("Erro na execução do processo filho");
            }
            
            buffer.close();
            
        } catch (IllegalThreadStateException  ex) {
            System.out.println("Erro de execução do processo filho");
        } catch (IOException ex){
            System.err.println("Programa não reconhecido.");
        } catch (Exception ex){
            System.out.print("");
        }
    }
    
    public static int testeProcesso(Process process){
        return process.exitValue();
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
