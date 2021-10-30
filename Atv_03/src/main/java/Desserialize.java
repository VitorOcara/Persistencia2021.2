import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class Desserialize {

    public void desserialize() throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream("yourfile.txt");
        ObjectInputStream obj = new ObjectInputStream(file);
        List lis = (ArrayList)obj.readObject();

        System.out.println(lis.getClass());

        for(Object p: lis){
            System.out.println(p);
        }


        file.close();
        obj.close();
    }
}
