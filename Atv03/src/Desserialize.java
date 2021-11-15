import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Desserialize {
    public void desserialize() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("yourfile.txt");
        ObjectInputStream obj = new ObjectInputStream(file);

        System.out.println(obj.readObject());
        file.close();
        obj.close();
    }
}
