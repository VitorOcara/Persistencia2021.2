import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Serialize ser = new Serialize();
        ser.addPessoas();
        ser.serializeJava();

        Desserialize desserializa = new Desserialize();
        desserializa.desserialize();

    }
}
