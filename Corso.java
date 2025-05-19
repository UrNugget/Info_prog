/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author campanim
 */
public class Corso {

    //codice, nome, durata (anni).
    private String codice, nome;
    private int durata;
    private ArrayList<Disciplina> discipline = new ArrayList<>();

    //controlli
    public Corso(String codice, String nome, int durata) {
        this.codice = codice;
        this.nome = nome;
        this.durata = durata;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getDurata() {
        return durata;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String stampaCorso() {
        return codice + " " + nome + " " + durata+'\n';
    }

    public void addDisciplina(Disciplina d) {
        discipline.add(d);
    }

    public boolean controllo(String codiceDisciplina) {
        for (int i = 0; i < discipline.size(); i++) {
            if(discipline.get(i).getCodice().equals(codiceDisciplina)){
                return true;
            }
        }
        return false;
    }

}
