/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author campanim
 */
public class Gestore {

    ArrayList<Studente> studenti = new ArrayList<>();
    ArrayList<Docente> docenti = new ArrayList<>();
    ArrayList<Corso> corsi = new ArrayList<>();
    ArrayList<Disciplina> discipline = new ArrayList<>();
    ArrayList<Appello> appelli = new ArrayList<>();

    public void caricaStudenti() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("studenti.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(ch);
                String matricola = data[0];
                String nome = data[1];
                String cognome = data[2];
                Corso c = null;
                for (int i = 0; i < corsi.size(); i++) {
                    if (corsi.get(i).getCodice().equals(data[3])) {
                        c = corsi.get(i);
                    }
                }
                Studente p = new Studente(matricola, nome, cognome, c);
                studenti.add(p);
            }
        } catch (IOException e) {

        }
    }

    public String stampaStudenti() {
        String s = "";
        for (Studente ss : studenti) {
            s += ss.stampaStudente();
        }
        return s;
    }

    public void aggiungiStudente(String matricola, String nome, String cognome, Corso corso) {
       
        Studente nuovoStudente = new Studente(matricola, nome, cognome, corso);
        studenti.add(nuovoStudente);

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("studenti.csv", true))) {
            writer.write(matricola + ";" + nome + ";" + cognome + ";" + corso.getCodice()+"\n");
        } catch (IOException e) {
        }
    }

    public void caricaDocenti() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("docenti.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(ch);
                String matricola = data[0];
                String nome = data[1];
                String cognome = data[2];
                Disciplina dd = null;
                for (Disciplina i : discipline) {
                    if (i.getCodice().equals(data[3])) {
                        dd = i;
                    }
                }
                Docente d = new Docente(matricola, nome, cognome, dd);
                docenti.add(d);
            }
        } catch (IOException e) {

        }
    }

    public String stampaDocenti() {
        String s = "";
        for (Docente d : docenti) {
            s += d.stampaDocente();
        }
        return s;
    }

    public void aggiungiDocente(String matricola, String nome, String cognome, Disciplina disciplina) {
        
        Docente nuovoDocente = new Docente(matricola, nome, cognome, disciplina);
        docenti.add(nuovoDocente);
        
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("docenti.csv", true))) {
            writer.write(matricola + ";" + nome + ";" + cognome + ";" + disciplina.getCodice()+"\n");
        } catch (IOException e) {
        }
        
    }

    public void caricaCorsi() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("corsi.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(ch);
                String codice = data[0];
                String nome = data[1];
                int durata = Integer.parseInt(data[2]);

                Corso c = new Corso(codice, nome, durata);
                corsi.add(c);
            }
        } catch (IOException e) {

        }
    }

    public String stampaCorsi() {
        String s = "";
        for (Corso c : corsi) {
            s += c.stampaCorso();
        }
        return s;
    }

    public void aggiungiCorso(String codice, String nome, int durata) {
        Corso nuovoCorso = new Corso(codice, nome, durata);
        corsi.add(nuovoCorso);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("corsi.csv", true))) {
            writer.write(codice+";"+nome+";"+durata+"\n");
        }
        catch (IOException e) {
        }
    }

    public void modificaCorso(String codice, String nome, int durata) {
        for (Corso i : corsi) {
            if (i.getCodice().equals(codice)) {
                i.setDurata(durata);
                i.setNome(nome);
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("corsi.csv", false));){
            writer.write("codiceCorso;nomeCorso;durataAnni");
            writer.newLine();
            
            for (Corso i: corsi) {
                writer.write(i.getCodice() + ";"+ i.getNome()+";"+i.getDurata());
                writer.newLine();
            }
        }
        catch (IOException e) {
        }
        
    }
    
    public void modificaAppello(String id, String data, Disciplina d) {
        for (Appello i : appelli) {
            if ((i.getId()).equals(id)) {
                i.setData(data);
                i.setDisciplina(d);
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appelli.csv", false));){
            writer.write("idAppello;data;codiceDisciplina");
            writer.newLine();
            
            for (Appello i: appelli) {
                writer.write(i.getId() + ";"+ i.getData()+";"+i.getDisciplina().getCodice());
                writer.newLine();
            }
        }
        catch (IOException e) {
        }
        
    }
    
    public void modificaDiscipina(String codice, String nome, int cfu, Corso c) {
        for (Disciplina i : discipline) {
            if ((i.getCodice()).equals(codice)) {
                i.setNome(nome);
                i.setCfu(cfu);
                i.setCorso(c);               
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("discipline.csv", false));){
            writer.write("codiceDisciplina;nomeDisciplina;cfu;codiceCorso");
            writer.newLine();
            
            for (Disciplina i: discipline) {
                writer.write(i.getCodice() + ";"+ i.getNome()+";"+i.getCfu()+";"+i.getC().getCodice());
                writer.newLine();
            }
        }
        catch (IOException e) {
        }
    }
    
    public void modificaDocente(String matricola, String nome, String cognome, Disciplina d) {
        for (Docente i : docenti) {
            if ((i.getMatricola()).equals(matricola)) {
                i.setNome(nome);
                i.setCognome(cognome);
                i.setDisciplina(d);               
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("docenti.csv", false));){
            writer.write("matricolaDocente;nome;cognome;codiceDisciplina");
            writer.newLine();
            
            for (Docente i: docenti) {
                writer.write(i.getMatricola()+";"+i.getNome() + ";"+ i.getCognome()+";"+i.getDisciplina().getCodice());
                writer.newLine();
            }
        }
        catch (IOException e) {
        }
    }
    
    public void modificaStudente(String matricola, String nome, String cognome, Corso c) {
        for (Studente i : studenti) {
            if ((i.getMatricola()).equals(matricola)) {
                i.setNome(nome);
                i.setCognome(cognome);
                i.setCorso(c);               
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("studenti.csv", false));){
            writer.write("matricolaStudente;nome;cognome;codiceCorso");
            writer.newLine();
            
            for (Studente i: studenti) {
                writer.write(i.getMatricola() + ";"+ i.getNome()+";"+i.getCognome() + ";" + i.getCorsoObj().getCodice());
                writer.newLine();
            }
        }
        catch (IOException e) {
        }
    }

    public void caricaDiscipline() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("discipline.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(ch);
                String codice = data[0];
                String nome = data[1];
                int cfu = Integer.parseInt(data[2]);
                Corso c = null;
                for (int i = 0; i < corsi.size(); i++) {
                    if (corsi.get(i).getCodice().equals(data[3])) {
                        c = corsi.get(i);
                    }
                }
                Disciplina d = new Disciplina(codice, nome, cfu, c);
                c.addDisciplina(d);

                discipline.add(d);
            }
        } catch (IOException e) {

        }
    }

    public String stampaDiscipline() {
        String s = "";
        for (Disciplina d : discipline) {
            s += d.stampaDisciplina();
        }
        return s;
    }
    
    public Corso controlloCorso(String cod) {
        for (Corso i : corsi) {
            if (i.getCodice().equals(cod)) return i;
        }
        return null;
    }
    
    public void aggiungiDisciplina(String codice, String nome, int cfu, Corso corso) {
        Disciplina nuovaDisciplina = new Disciplina(codice, nome, cfu, corso);
        discipline.add(nuovaDisciplina);
        
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("discipline.csv", true))) {
            writer.write(codice + ";" + nome + ";" + cfu + ";" + corso.getCodice()+"\n");
        } catch (IOException e) {
        }
    }

    public void caricaAppelli() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("appelli.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(ch);
                String id = data[0];
                String date = data[1];
                Disciplina d = null;
                for (int i = 0; i < discipline.size(); i++) {
                    if (discipline.get(i).getCodice().equals(data[2])) {
                        d = discipline.get(i);
                    }

                }

                Appello a = new Appello(id, date, d);
                appelli.add(a);
            }
        } catch (IOException e) {

        }
    }

    public String stampaAppelli() {
        String s = "";
        for (Appello a : appelli) {
            s += a.stampaAppello();
            
            System.out.println(a.stampaIscrizioni());
        }
        return s;
    }
    
    public Disciplina controlloDisciplina(String cod) {
        for (Disciplina i : discipline) {
            if (i.getCodice().equals(cod)) return i;
        }
        return null;
    }
    
    public void aggiungiAppello(String id, String data, Disciplina d) {        
        Appello nuovoAppello = new Appello(id, data, d);
        appelli.add(nuovoAppello);
        
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("appelli.csv", true))) {
            writer.write(id + ";" + data + ";" + d.getCodice() +"\n");
        } catch (IOException e) {
        }
    }

    public void caricaIscrizioni() {
        String ch = ";";
        String line;

        try ( BufferedReader br = new BufferedReader(new FileReader("iscrizioni_appelli.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(ch);
                String id = data[0];
                String matricola = data[1];

                Appello a = null;
                for (int i = 0; i < appelli.size(); i++) {
                    if (id.equals(appelli.get(i).getId())) {
                        a = appelli.get(i);
                    }
                }
                Studente s = null;
                for (int i = 0; i < studenti.size(); i++) {
                    if (matricola.equals(studenti.get(i).getMatricola())) {
                        s = studenti.get(i);
                    }
                }

                if (s.getCorsoObj()!=null && a.getDisciplina()!=null) {
                    if (s.getCorsoObj().controllo(a.getDisciplina().getCodice())) {
                        System.out.println("Iscrizione completata!");
                        a.iscrizione(s);
                    }
                    else System.out.println("Iscrizione fallita...");
                }
                //String codiceDisciplinaIscrizione 

            }
        } catch (IOException e) {

        }
    }

    public void stampaIscrizioni() {
        for (int i = 0; i < appelli.size(); i++) {
            System.out.println(appelli.get(i).getId() + ": ");
            appelli.get(i).stampaIscrizioni();

        }
    }

    public void eliminaStudente(Studente s) {
        for (int i = 0; i < appelli.size(); i++) {
            for (int j = 0; j < appelli.get(i).studenti.size(); i++) {
                if (appelli.get(i).studenti.get(j).equals(s)) {
                    System.out.println("la cancellazione non è andata a buon fine");
                    return;
                }
            }
        }
        System.out.println("cancellazione completata");

    }

    public void eliminaAppello(Appello a) {
        if (a.studenti.size() == 0) {
            System.out.println("cancellazione completata");
            return;
        }
        System.out.println("la cancellazione non è andata a buon fine");

    }

    public void eliminaCorso(Corso c) {
        for (Studente s : studenti) {
            if (s.getCorsoObj() == c) {
                System.out.println("la cancellazione non è andata a buon fine");
                return;
            }

        }
        for (Docente d : docenti) {
            if (d.getDisciplina().getC() == c) {
                System.out.println("la cancellazione non è andata a buon fine");
                return;
            }
        }
        for (Appello a : appelli) {
            if (a.getDisciplina().getC() == c) {
                System.out.println("la cancellazione non è andata a buon fine");
                return;
            }
        }
        System.out.println("cancellazione completata");

    }

    public void eliminaDocente(Docente d) {
        for (Disciplina i : discipline) {
            if (i == d.getDisciplina()) {
                System.out.println("la cancellazione non è andata a buon fine");
                return;
            }
        }
        System.out.println("cancellazione completata");

    }

}
