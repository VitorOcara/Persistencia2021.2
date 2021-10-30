import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

public class Qt_01 {

    public static Properties getProp(Properties prop) throws IOException {
        FileInputStream file = new FileInputStream("./resources/config.properties");
        prop.load(file);
        return prop;
    }

    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);
        Properties properties = new Properties();
        getProp(properties);

        int linhaInicial = Integer.parseInt(properties.getProperty("linha_inicial"));
        int linhaFinal = Integer.parseInt(properties.getProperty("linha_final"));

        System.out.println("Digite o nome do arquivo: ");
        String arq = scan.next();

        FileInputStream file = new FileInputStream(arq);
        InputStreamReader isr = new InputStreamReader(file);
        BufferedReader bfr = new BufferedReader(isr);

        String aux = bfr.readLine();

        int cont = 1;


        while (cont <= linhaFinal && aux!= null) {
            if(cont >= linhaInicial){
                System.out.println(aux);
            }
            cont++;
            aux = bfr.readLine();
        }
    }
}









