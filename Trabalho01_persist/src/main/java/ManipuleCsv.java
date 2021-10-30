import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuleCsv {

    public void lerCsv(String arquivo) throws IOException {

        FileReader fr = new FileReader(arquivo);
        BufferedReader bfr = new BufferedReader(fr);

        String linha ;
        String divisor= ",";

        String[] aux;

        List<Computador> computadores = new ArrayList<>();
        while ((linha = bfr.readLine()) != null) {
            aux = (linha.split(divisor));
            Computador c = new Computador(aux[0], aux[1], aux[2], aux[3], aux[4], aux[5]);
            computadores.add(c);
        }
        serializeJson(computadores);
        serializeXml(computadores);

    }

    public void serializeJson(List<Computador> computadores) throws IOException {
        ObjectMapper map = new ObjectMapper();
        File file = new File("Dados.json");

        map.writeValue(file, computadores);


    }
    public void serializeXml(List<Computador> computadores) throws IOException {
        XmlMapper xml = new XmlMapper();
        File file = new File("Dados.xml");
        xml.writeValue(file,computadores);
    }

}
