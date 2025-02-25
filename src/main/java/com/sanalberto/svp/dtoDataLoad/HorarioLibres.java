package com.sanalberto.svp.dtoDataLoad;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name="horario")
public class HorarioLibres {
    ArrayList<AulasLibresHora> horas;
    public HorarioLibres() {}

    @XmlElement(name="aulasLibresHora")
    public ArrayList<AulasLibresHora> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<AulasLibresHora> horas) {
        this.horas = horas;
    }
}
