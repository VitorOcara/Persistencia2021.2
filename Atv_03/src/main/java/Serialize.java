import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Serialize {

    List<Pessoa> pessoas = new ArrayList<>();

    int[] ids = {101,102,103,104,105,106};
    String[] nomes ={ "Jose", "Frank", "Aquino", "Vitor", "Marcos","Maurício" };
    String[] emails ={ "josee@gmail.com", "franksteinn@hotmail.com", "akinorego@gmail.com",
            "vitor1310@gmail.com", "marcose@outlook.com", "marcinho3bola@gmail.com"};
    String[] fones ={ "3322 4422","85991223344","3322 2211","0800 7776","2133 8811","1199122334455"};


    public void addPessoas(){
        for (int i =0; i < ids.length ;i++){
            Pessoa pessoa = new Pessoa(ids[i], nomes[i], emails[i], fones[i]);
            pessoas.add(pessoa);
        }
    }

    public void serializeJava() throws IOException {
        FileOutputStream file = new FileOutputStream("yourfile.txt");
        ObjectOutputStream obj = new ObjectOutputStream(file);

        obj.writeObject(pessoas);

        obj.flush();
        obj.close();
        file.flush();
        file.close();

    }

    public void serializeJson() throws IOException{

        ObjectMapper map = new ObjectMapper();
        map.writeValue(new File("target/pessoas.json"), pessoas);
    }

    public void serializeXml() throws IOException{

        XmlMapper xmlMapper = new XmlMapper();
        File f = new File("pessoas.xml");
        xmlMapper.writeValue(f,pessoas);
    }

}
