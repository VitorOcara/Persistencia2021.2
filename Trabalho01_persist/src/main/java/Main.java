import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Cadastra cadastra = new Cadastra();
        cadastra.cadastra();

        ManipuleCsv des = new ManipuleCsv();
        des.lerCsv("Dados.csv");
    }
}