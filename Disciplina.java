/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author campanim
 */
public class Disciplina {
    //codiceDisciplina;nomeDisciplina;cfu;codiceCorso

    private String codice, nome;
    private Corso c;
    private int cfu;

    public Disciplina(String codice, String nome, int cfu, Corso c) {
        this.codice = codice;
        this.nome = nome;
        this.cfu = cfu;
        this.c = c;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public Corso getC() {
        return c;
    }

    public int getCfu() {
        return cfu;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCorso(Corso c) {
        this.c = c;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }
    
    

    public String stampaDisciplina() {
        return codice + " " + nome + " " + cfu + " " + c.getCodice() + '\n';
    }

}
