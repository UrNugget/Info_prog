/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author campanim
 */
public class Studente {

    //matricola studente, nome, cognome, corso di iscrizione
    private String matricola, nome, cognome;
    private Corso corso;

    //controlli
    public Studente(String matricola, String nome, String cognome, Corso corso) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
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

    public String getCorso() {
        return corso.getCodice();
    }
    
     public Corso getCorsoObj() {
        return corso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
     
    

    public String stampaStudente() {
        return matricola + " " + nome + " " + cognome + " " + corso.getCodice() + '\n';
    }
    
    

}
