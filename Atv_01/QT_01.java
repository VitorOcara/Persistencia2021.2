package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QT_01 {

    public static void Read(String arq, String s) throws IOException{

            InputStream file = new FileInputStream(arq);

            InputStreamReader filer = new InputStreamReader(file);
            BufferedReader bf = new BufferedReader(filer);

            String ab = bf.readLine();
            if(ab.contains(s)){
                System.out.println(ab);
            }

            while (ab!=null){
                ab = bf.readLine();
                if(ab!=null && ab.contains(s)){
                    System.out.println(ab);
                }
            }
    }


     public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do txt com a extensão: ");
        String arquivo = scan.nextLine();

        System.out.println("String que você procura");
        String a = scan.nextLine();

        Read(arquivo, a);

    }
}



