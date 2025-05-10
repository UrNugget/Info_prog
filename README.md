# Info_prog
progetto info 4m

# Scheda Progetto - Gestione Corsi Universitari

# Obiettivo:

Realizzare un'applicazione Java con interfaccia grafica (GUI) sviluppata in NetBeans, che consenta di gestire:
- Corsi universitari;
- Studenti;
- Docenti;
- Discipline;
- Appelli d’esame.


I dati dovranno essere persistenti utilizzando file CSV.

# Specifiche funzionali:

# Gestione dei corsi
- Creazione, visualizzazione e modifica di corsi universitari;
- Ogni corso ha: codice, nome, durata (anni).


# Gestione delle discipline:
- Creazione e assegnazione di discipline a un corso;
- Ogni disciplina ha: codice, nome, numero di CFU.


# Gestione dei docenti
- Inserimento, modifica e visualizzazione dei docenti;
- Ogni docente insegna una sola disciplina;
- Dati richiesti: matricola docente, nome, cognome, disciplina insegnata.


# Gestione degli studenti
- Registrazione e gestione studenti;
- Ogni studente è iscritto a un solo corso;
- Dati richiesti: matricola studente, nome, cognome, corso di iscrizione.


# Gestione degli appelli d’esame
- Creazione degli appelli per una disciplina di un corso;
- Ogni appello deve avere: data esame, disciplina, docente, lista degli studenti iscritti.


# Iscrizione agli appelli
Gli studenti possono iscriversi agli appelli solo delle discipline del proprio corso.

# Specifiche tecniche
Linguaggio: Java
IDE: NetBeans (uso di Swing per la GUI)
Persistenza dati: Lettura e scrittura su file CSV.
Architettura consigliata: MVC (Model-View-Controller)

# Requisiti tecnici
Schema UML delle classi
Realizzazione delle classi necessarie
Realizzazione di un classe Gestore (punto di collegamento fra l’applicazione grafica e le classi)

# Requisiti obbligatori
Interfaccia grafica intuitiva:
Menù principale con sezioni per Corsi, Discipline, Docenti, Studenti, Appelli.
Finestra per l'inserimento/modifica dei dati.
Tabelle per visualizzare gli elenchi.
(F) Validazione dei dati (es. non permettere a uno studente di iscriversi a un esame di un'altra facoltà).
Salvataggio tramite pulsante "Salva" delle modifiche nei file CSV.
Caricamento dati all'avvio dell'applicazione.

# Struttura dei file CSV (esempio)
corsi.csv
 codiceCorso;nomeCorso;durataAnni


discipline.csv
 codiceDisciplina;nomeDisciplina;cfu;codiceCorso


docenti.csv
 matricolaDocente;nome;cognome;codiceDisciplina


studenti.csv
 matricolaStudente;nome;cognome;codiceCorso


appelli.csv
 idAppello;data;codiceDisciplina


iscrizioni_appelli.csv
 idAppello;matricolaStudente



# Esempi GUI principali
Maschera "Gestione Studenti" (aggiungi, modifica, elimina studente).
Maschera "Visualizza Corsi" (tabella corsi con pulsante "Aggiungi corso").
Maschera "Gestione Appelli" (seleziona disciplina, crea appello).
Maschera "Iscrizione Studente a Appello".



# Vincoli
Non puoi eliminare un Corso se ci sono studenti, docenti o esami collegati
Non puoi eliminare un Appello se ci sono studenti iscritti
Non puoi eliminare uno Studente se è iscritto a qualche appello
Non puoi eliminare un Docente se ci sono materie collegate

# Extra facoltativi (per chi vuole approfondire)
Aggiunta di voti d’esame e verbalizzazione.
Filtri di ricerca nelle tabelle (es. cerca per nome o codice).
Esportazione di report (es. elenco studenti iscritti a un appello).


# Esempi CSV
corsi.csv
codiceCorso;nomeCorso;durataAnni
C001;Ingegneria Informatica;5
C002;Lettere;3


discipline.csv
codiceDisciplina;nomeDisciplina;cfu;codiceCorso
D001;Informatica;9;C001
D002;Elettronica;6;C001
D003;Letteratura Italiana;9;C002
D004;Storia Moderna;3;C002


docenti.csv
matricolaDocente;nome;cognome;codiceDisciplina
P01;Alan;Turing;D001
P02;Steve;Jobs;D002
P03;Luigi;Pirandello;D003
P04;Alessandro;Barbero;D004


studenti.csv
matricolaStudente;nome;cognome;codiceCorso
S001;Franco;Rosso;C001
S002;Antonio;Conte;C001
S003;Luisa;Pollini;C001
S004;Marina;Tremonti;C002
S005;Zoe;Grassi;C002



appelli.csv
idAppello;data;codiceDisciplina
A01;2025-06-01;D001
A02;2025-06-03;D002
A03;2025-07-03;D001
A04;2025-07-05;D003



iscrizioni_appelli.csv
idAppello;matricolaStudente
A01;S001
A01;S002
A03;S001
A04;S004

