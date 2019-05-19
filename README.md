# Workshop4c (UI Engineering) Assignment 2

## Bearbeitet von
 - Vorname Nachname 
 
## Abgabe
- Montag, 13.5.2018, 10:00 Uhr
- Die Abgabe erfolgt durch ein "Push" auf den Master-Branch Ihres GitHub-Repositories.
 
## Formular einer Geschäftsapplikation

Implementieren Sie ein Formular, das die typischen Anforderungen einer Geschäftsapplikation erfüllt. 

Das zu implementierende Formular dient der Eingabe und Verwaltung eines Kantons.

Das UI soll auf Basis JavaFX umgesetzt werden. Sie können FormsFX verwenden, müssen aber nicht.

Als Ausgangsbasis ist im Repository eine Teil-Applikation enthalten.
 - Der Service-Layer, die notwendigen Presentation-Model-Klassen und die Toolbar und der Header des UI sind vorhanden.
 - Es fehlt das komplette Formular.
 - Entscheiden Sie auf welcher Basis Sie das Formular implementieren wollen - mit FormsFX, mit dem "attribute-based Ansatz" oder mit einer Eigenentwicklung.


## Bewertung:
 - Es können in diesem Assignment 2 Punkte erreicht werden, wenn mindestens:
   - die Implementierung die im Unterricht erarbeiteten Architektur-Regeln umsetzt
   - alle Attribute des CantonPM im Formular vorhanden sind
   - die Werte, die im Header angezeigt werden, sofort aktualisiert werden sobald im Formular der entsprechende Wert geändert wird
       - die im gegebenen Header bereits dargestellten Informationen dürfen nicht entfernt werden
   - das Formular "zweispaltig" ist
       - eine Spalte besteht aus der Beschriftung und dem Eingabefeld für jedes Attribut
   - Mehrsprachigkeit ist umgesetzt 
       - es kann via die entsprechenden Buttons zwischen Deutsch und Englisch gewechselt werden
   - diese Validierungen umgesetzt sind 
       - alle Eingaben sind syntaktisch korrekt
       - die obligatorischen Felder "kanton", "kuerzel", "kantonsnummer" sind nicht leer
       - die numerischen Werte sind in einem plausiblen Wertebereich
       - das Feld "einwohnerdichte" wird auf read-only gesetzt sobald die beiden Werte "einwohner" und "flaeche" angeben werden. 
         Solange einer der beiden Werte fehlt, kann "einwohnerdichte" editiert werden.
 
 - 1 Punkt gibt es falls nur ein Teil der Anforderungen umgesetzt wurde       

 - Nicht compilier-fähiger Code oder ein Plagiat ergibt 0 Punkte
 

## Bitte beachten Sie:
 - Tragen Sie ihren Namen unter "Bearbeitet von" ein. Manche GitHub-Account-Namen können nicht
 eindeutig einer Person zugeordnet werden.
 
 - Es wird empfohlen die Assignment-Aufgaben, genau wie das Programmierprojekt, in einem 2er-Team zu bearbeiten. 
 
 - Falls Sie das Assignment zu zweit bearbeiten:
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