# Workshop4c (UI Engineering) Abschlussprojekt

## Bearbeitet von
 - Vorname Nachname 
 
## Abgabe und Präsentation
- Montag, 3.6.2019
- Die Abgabe erfolgt durch ein "Push" auf den Master-Branch Ihres GitHub-Repositories.
 
## Entwicklung einer Geschäftsapplikation

Implementieren Sie eine Applikation Ihrer Wahl, die mehrere der typischen Anforderungen einer Geschäftsapplikation erfüllt, z.B.: 
  - die Themen aus dem Unterricht (Kantone, Gemeinden, Schweizer Berge) sind ausgeschlossen
  - effiziente Dateneingabe in einem hochfunktionalen Formular (Validierung, Visualisierung obligatorischer Felder, readOnly/writeable-Umschaltung, ...)
      - Applikationen, die überwiegend Daten anzeigen ohne diese Daten verändern zu können, sind nicht genügend.
  - effiziente Behandlung von grossen Datenmengen
  - Unterstützung der CRUD-Operationen für das Anlegen, Einlesen, Verändern und Löschen von Datensätzen
  - durchgängige Mehrsprachigkeit
  - Unterstützung von Undo/Redo
  - inkrementelle Suche
  - geeignete, auf die jeweilige Anwendungsdomäne angepasste, UI-Elemente
  
Die Implementierung muss auf den im Unterricht erarbeiteten Grundkonzepten beruhen
  - 3-Layer Architektur
  - Einsatz von DTOs im Service-Layer
  - asynchrone Service-Calls
  - konsequente Trennung von Model und View
  - gegebenenfalls konsequente Umsetzung von MVC in der im Unterricht besprochenen Variante.
  
Die Applikation muss mit Java und mit JavaFX als UI-Technologie implementiert werden. Es ist erlaubt, hilfreiche 
Libraries zu verwenden, insbesondere FormsFX, PreferencesFX und WorkbenchFX.

Falls WorkbenchFX zum Einsatz kommt:
  - Es können mehrere Teams zusammenarbeiten und eine gemeinsame WorkbenchFX-basierte Applikation bearbeiten
  - Jedes Team muss eindeutig einem (oder mehreren) WorkbenchFX-Modul zugeordnet werden können.
  - WorkbenchFX dient der Integration dieser einzelnen Module zu einer Gesamtapplikation. 
  - die obigen Anforderungen gelten sinngemäss für jedes einzelne Modul

Als Ausgangsbasis ist im Repository das entsprechende Application-Template aus dem Unterricht enthalten.


## Bewertung:
 - Es können in diesem Abschlussprojekt 10 Punkte erreicht werden, falls
   - die Implementierung die im Unterricht erarbeiteten Architektur-Regeln umsetzt (maximal 4 Punkte)
   - mindestens 4 oben genannten grundlegenden Anforderungen an eine Geschäftsapplikation umgesetzt sind (maximal 6 Punkte)
   
 - Wenn die Architektur-Regeln nicht eingehalten werden, können insgesamt maximal 4 Punkte erreicht werden, unabhängig von der Anzahl der 
   implementierten Features
   
 - Handelt es sich um keine typische Geschäftsapplikation, z.B. ein Spiel oder eine Such- und Anzeige-Applikation können ebenfalls maximal 4 Punkte erreicht werden.  
 
 - Nicht compilier-fähiger Code oder ein Plagiat ergibt 0 Punkte
 

## Bitte beachten Sie:
 - Tragen Sie ihren Namen unter "Bearbeitet von" ein. Manche GitHub-Account-Namen können nicht eindeutig einer Person zugeordnet werden.
 
 - Es wird empfohlen, das Programmierprojekt in einem 2er-Team zu bearbeiten. 
 
 - Falls Sie das Projekt zu zweit bearbeiten:
   - tragen Sie beide Namen unter "Bearbeitet von" ein
   - arbeiten Sie ausschliesslich in einem Repository
   - falls sie beide Zugang zu diesem Repository wollen: tragen Sie die zweite Person als "Collaborator" ein (auf GitHub unter "Settings - > Collaborators & teams")
   - löschen Sie das nicht benötigte Repository (auf GitHub unter "Settings")
   - arbeiten Sie gemeinsam und gleichzeitig an den Aufgaben (Stichwort: Pair-Programming)
   - das Aufteilen und separate Bearbeiten von Teil-Aufgaben ist nicht erwünscht
 
 - Ausdrücklich erlaubt und erwünscht ist, dass Sie sich gegebenenfalls Hilfe holen. Nachfragen werden zum Beispiel über den im Repository integrierten 
 Issue Tracker oder per Mail gerne beantwortet. 
 
 
 ## Bei Problemen mit dem IntelliJ-Setup
 Es kommt immer wieder mal vor, dass der Setup des IntelliJ-Projekts nicht auf Anhieb funktioniert oder "plötzlich"
 nicht mehr funktioniert.
 
 Sie brauchen in so einem Fall NICHT nochmal den Invitation-Link annehmen oder das Projekt via “Check out from Version Control” oder "git clone ..." nochmal anlegen.
 
 Statt dessen ist es am besten den IntelliJ-Setup neu generieren zu lassen. Dazu verwendet man den File "build.gradle", der eine 
 komplette und IDE-unabhängige Projektbeschreibung enthält.
 
 Die einzelnen Schritte:
 
 - Schliessen Sie alle geöffneten Projekte (File -> Close Project)
 
 - Wählen Sie “OPEN” 
 
 - Es erscheint ein Finder-Fenster mit dem Sie zu ihrem Projekt navigieren.
 
 - Dort wählen Sie den File “build.gradle” aus.
 
 - Beim nächsten Dialog “Open as Project” wählen.
 
 - Beim nächsten Dialog kontrollieren ob der Liberica JDK 11 ausgewählt ist.
 
 - Dann “File already exists” mit YES bestätigen.
 
 - ACHTUNG: Jetzt “Delete existing Project and Import” anklicken.
 
 - Warten, warten, warten.
 
 Wenn alles gut gegangen ist sollte im Project-View der Java-Ordner unter src/main blau sein und der Java-Ordner unter src/test grün.