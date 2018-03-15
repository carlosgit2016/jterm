
import com.sun.corba.se.impl.io.IIOPInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import jterm.ComandoPrompt;
import jterm.ComandosInternos;




/**
 * Write a description of class QuickSort here.
 * 
 * @author (your name) 
 * @version (a version numbe or a date)
 */

public class Teste {
        
    public static void main(String[] args) throws IOException   {
        ProcessBuilder pb = new ProcessBuilder("/home/carlos/NetBeansProjects/jTerm/./teste.sh");
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String cOuString ;
        while ((cOuString = br.readLine()) != null) {
            System.out.println(cOuString);
        }
    }
    
        
}
