package com.sanalberto.svp.dataLoad;

import com.sanalberto.svp.dtoDataLoad.AulasLibresHora;
import com.sanalberto.svp.dtoDataLoad.HorarioLibres;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class DataFromCSV {

    //método para cargar en una variable toda la información de aulas libres por hora
    public HorarioLibres readCSV() {
        String folderName ="src/main/resources";
        HorarioLibres horario = new HorarioLibres();
        horario.setHoras(new ArrayList<>());
        try {
            for (int i = 1; i <= 6; i++){
                String fileName = "/HorasLibresSAMHora" + i + ".csv";
                Path p = Paths.get(folderName, fileName);

                ArrayList<String> lineas = (ArrayList<String>) Files.readAllLines(p);
                for (String linea : lineas) {
                    AulasLibresHora a = new AulasLibresHora();
                    a.setHora(i);
                    a.setAulas(new ArrayList<>());//recorro los días de la semana
                    String[] aulas = linea.split(";");
                    a.setDiaSemana(aulas[0]);
                    for (int j = 1; j < aulas.length-1; j++) {
                        if (!Objects.equals(aulas[j], "")) {
                            a.getAulas().add(aulas[j]);
                        }
                    }
                    horario.getHoras().add(a);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return horario;
    }
    //método para generar el xml con la información
    public void generateXML(HorarioLibres horario) {
        try {
            Path p = Path.of("target/horarioAulasLibres.xml");
            //En primer lugar se crea el contexto a partir de las anotaciones de la clase
            JAXBContext contextOut = JAXBContext.newInstance(HorarioLibres.class);
            //instanciar un Marshaller
            Marshaller marshaller = contextOut.createMarshaller();
            //dar formato a la salida
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(horario, p.toFile());
        } catch (JAXBException e) {
            System.out.println("Error al generar el archivo. "+e);
        }
    }
}
