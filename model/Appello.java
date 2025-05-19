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
public class Appello {

    //data esame, disciplina, docente, lista degli studenti iscritti.
    private String id;
    private String data;
    private Disciplina disciplina;
    public  ArrayList<Studente> studenti = new ArrayList<Studente>();

    public Appello(String id, String data, Disciplina disciplina) {
        this.id = id;
        this.data = data;
        this.disciplina = disciplina;
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    

    public String stampaAppello() {
        String s = id + " " + data + " " + disciplina.getCodice()+'\n';
        
        s += this.stampaIscrizioni();
        
        return s;
    }

    public void iscrizione(Studente s) {
        studenti.add(s);
    }

    public String stampaIscrizioni() {
        String s = "";
        for (int i = 0; i < studenti.size(); i++) {
            System.out.print("  ");

            s += "     " + studenti.get(i).stampaStudente();
        }
        
        return s;
    }

}
