import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class Qt_01 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o arquivo Origem: ");
        String arqOri = scan.next();

        System.out.println("Digite o arquivo Destino: ");
        String arqDest = scan.next();

        File arq = new File(arqOri);

        long tempo = System.currentTimeMillis();

        byte[] bytes = Files.readAllBytes(arq.toPath());
        String text = new String(bytes, "UTF-8");
        PrintWriter pw = new PrintWriter(arqDest);
        pw.print(text);
        pw.close();
        System.out.println("O tempo total de cópia foi "+ (System.currentTimeMillis() - tempo)+ " milisegundos.");
    }
}
