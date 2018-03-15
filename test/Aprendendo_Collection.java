
import java.util.ArrayList;

import java.util.*;
import jdk.nashorn.internal.objects.NativeArray;
/*
 * Aprendendo sobre array List:
 * 
 */

/**
 *
 * @author Carlos Gabriel Goiani FLor
 */
public class Aprendendo_Collection {
    public static void main(String[] args) {
        //Objetos String para testes
        String argumento1 = "bianca";
        String argumento2 = "amora";
        String argumento3 = "/bin/bash";
        String argumento4 = "/";
        String argumento5 = "/etc/apache2";
        
        //Array List pertencendo a Collection de listas
        //Criando instancia para ArrayList
        ArrayList<String> argumentos;
        //Criando uma nova arraylist
        argumentos = new ArrayList<>();
        //Adicionando objetos tipo String, argumentos 1,2,3
        argumentos.add(argumento1);
        argumentos.add(argumento2);
        argumentos.add(argumento3);
        
        //Criando lista de argumentos2
        ArrayList<String> argumentos2 = new ArrayList<>();
        
        //Atribuindo todos os objetos da lista de argumentos1
        argumentos2.addAll(argumentos);
        //Adicionando mais argumentos 4,5
        argumentos2.add(argumento4);
        argumentos2.add(argumento5); 
        
        //removendo objeto argumento1
        argumentos.remove(argumento1);
        //removendo objeto argumento1 da collection argumentos2
        argumentos2.remove(argumento1);
        
        //metodos das collections são diferentes da arrays,porém executam a mesma tarefa
        //.size() retorna a quantidade de elementos dentro de uma collection
        System.out.println(argumentos.size());
        //for usado para abreviação....
        //mesma coisa que for(int i = 0;  i < argumentos.size();i++)
        //For não abreviado.
        for(int i = 0 ; i < argumentos.size(); i ++){
            System.out.println("for não abreviado: " + argumentos.get(i));
        }
        //para cada argumento dentro de argumentos faça o seguinte....
        for(String argumento : argumentos){
            System.out.println(argumento);
        }
        //Percorrendo e printando collection argumentos 2
        for(String argumento : argumentos2){
            System.out.println(argumento);
        }
        
        //foreach a partir do JAVA 8 como metodo das collections
        //Faz a mesma função que os fors de cima 
        //A vantagem é sobre paralelismo e mutabilidade
        argumentos.forEach(argumento -> {
            System.out.println("percorrrendo argumento:" + argumento);
        });
        
        //Metodo ordena de cordo com a ordem lexical da String(Alfabetica)
        //Ordenando usando a classe Collections que é diferente da interface Collection.
        Collections.sort(argumentos);
        //Ordenando usando a classe Collections que é diferente da interface Collection.
        Collections.sort(argumentos2);
        
        argumentos.add(argumento1);
        argumentos2.add(argumento1);
        
        argumentos.forEach(argumento -> {
            System.out.println("Depois de ordenado argumentos1" + argumento);
        });
        
        argumentos2.forEach(argumento -> 
            {System.out.println("Depois de ordenado argumentos2 " + argumento);
        });
        
    }
}
