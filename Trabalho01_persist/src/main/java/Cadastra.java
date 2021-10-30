import java.io.*;
import java.util.Scanner;

public class Cadastra {


    public void writeInArq(Computador c, String arq) throws IOException {

        File file = new File(arq);
        FileOutputStream fos = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter output = new BufferedWriter(osw);

        String s =c.getGabinete() + ","+ c.getPlacaMae()+","+c.getPlacaDeVideo()+","+
                c.getProcessador()+","+ c.getHd()+","+c.getRam();

        output.write(s);
        output.newLine();
        output.flush();
        output.close();

    }

    public void cadastra() throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite as configurações do Computador: ");

        System.out.println("Gabinete: ");
        String gab = scan.nextLine();
        System.out.println("Placa Mãe: ");
        String placaM = scan.nextLine();
        System.out.println("Placa de Vídeo: ");
        String placaV = scan.nextLine();
        System.out.println("Processador: ");
        String processador = scan.nextLine();
        System.out.println("Hd capacidade em GB");
        String hd = scan.nextLine();
        System.out.println("Memoria Ram em GB");
        String ram = scan.nextLine();

        Computador comp = new Computador(gab, placaM, placaV,processador,hd,ram);

        String arquivo = "Dados.csv";
        writeInArq(comp, arquivo);
    }
}
