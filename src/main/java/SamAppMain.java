import com.sanalberto.svp.dataLoad.DataFromCSV;
import com.sanalberto.svp.dtoDataLoad.HorarioLibres;

public class SamAppMain {
    public static void main(String[] args) {
        DataFromCSV dataCsv = new DataFromCSV();
        dataCsv.generateXML(dataCsv.readCSV());
    }
}
