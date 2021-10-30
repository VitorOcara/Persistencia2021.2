package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QT_02 {

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


    public static ArrayList<String> Read(String arq){
        ArrayList<String> linhas = new ArrayList<>();
        try {
            InputStream file = new FileInputStream(arq);
            InputStreamReader filer = new InputStreamReader(file);
            BufferedReader bf = new BufferedReader(filer);
            try {
                String linha = bf.readLine();
                linhas.add(linha);

                while(linha!=null){
                    linha = bf.readLine();
                    linhas.add(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return linhas;
    }
    public static void Mostrar(ArrayList<String> arq, String linha){
        for (String s : arq) {
            if (s != null && s.contains(linha)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do txt1 com a extensão: ");
        String arquivo1 = scan.nextLine();
        System.out.println("Nome do txt2 com a extensão: ");
        String arquivo2 = scan.nextLine();
        System.out.println("Nome do txt3 com a extensão: ");
        String arquivo3 = scan.nextLine();

        ArrayList<String> arr1;
        ArrayList<String> arr2;


        arr1 = Read(arquivo1);
        arr2 = Read(arquivo2);
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.addAll(arr1);
        arr3.addAll(arr2);

        for(String s : arr3){
            if(s!= null){
                Escreve(s + "\n", arquivo3);
            }
        }

        ArrayList<String> arr4 = Read(arquivo3);
        for(String s : arr4){
            if(s!= null){
                System.out.println(s);
            }
        }



    }
}
