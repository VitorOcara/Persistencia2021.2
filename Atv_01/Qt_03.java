package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Qt_03 {
    public static void Escreve(String s, String a){
        try{
            OutputStream a1 = new FileOutputStream(a, true);
            OutputStreamWriter a2 = new OutputStreamWriter(a1);
            BufferedWriter ff = new BufferedWriter(a2);

            ff.write(s);
            ff.close();


        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public static void Read(String arq, String caminho) throws IOException{
        //ArrayList<String> linhas = new ArrayList<>();

            InputStream file = new FileInputStream(arq);
            InputStreamReader filer = new InputStreamReader(file);
            BufferedReader bf = new BufferedReader(filer);


                String linha = bf.readLine();
                Escreve(linha, caminho);
                while(linha!=null){
                    linha = bf.readLine();

                    Escreve(linha, caminho);
                }



    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("\n EX: a.txt copy b.txt");
        int a = 0;
        while (a < 3){
            arr.add(scan.next());
            a++;
        }

        while (!arr.get(1).equals("copy")){
            System.out.println("comando desconhecido digite apenas o comando novamente");
            arr.set(1, scan.next());
        }
        long tempoInicial = System.currentTimeMillis();
        Read(arr.get(0), arr.get(2));

        System.out.println("A cópia foi efetuada em : " + (System.currentTimeMillis() - tempoInicial) + "milisegundos");
    }


}
