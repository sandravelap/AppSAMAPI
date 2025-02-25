package com.sanalberto.svp.dtoDataLoad;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;

@XmlRootElement(name="aulasLibresHora")
@XmlType(propOrder = {"diaSemana", "hora", "aulas"})
public class AulasLibresHora {
    String diaSemana;
    Integer hora;
    ArrayList<String> aulas;
    public AulasLibresHora(){}

    @XmlElement(name="diaSemana")
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @XmlElement(name="hora")
    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    //cuando un elemento hijo es un array lo definimos como wrapper y definimos la etiqueta
    //del elemento que envuelve y el elemento envuelto
    @XmlElementWrapper(name="aulas")
    @XmlElement(name="aula")
    public ArrayList<String> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<String> aulas) {
        this.aulas = aulas;
    }
}
