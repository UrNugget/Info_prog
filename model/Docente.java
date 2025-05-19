/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author campanim
 */
public class Docente {

    //matricola docente, nome, cognome, disciplina insegnata.
    private String matricola, nome, cognome;
    private Disciplina disciplina;
    //controlli
    public Docente(String matricola, String nome, String cognome, Disciplina disciplina) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.disciplina = disciplina;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    

    public String stampaDocente() {
        return matricola + " " + nome + " " + cognome + " " + disciplina.getCodice() + '\n';
    }

}
