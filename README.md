#Impfzentrum Database-Connector
Dieser Programmrahmen stellt dir eine Vorlage für einen Datenbankzugriff mit Hilfe des DatabaseConnectors zur Verfügung.
Einige Stellen sind noch nicht implementiert.

## Anpassung in den Klassen
In diesen Klassen müsst ihr Anpassungen vornehmen.
1. **WindowsManager - connectToDatabase(...)**<br>
   Ergänze den Auftrag so, dass mit Hilfe der Klasse *DatabaseConnector* eine Verbindung mit der Datenbank hergestellt wird.
   Prüfe ob die Verbindung erfolgreich hergestellt wurde:
   * Wurde die Verbindung erfolgreich hergestellt, rufe den Auftrag *success(...)* auf.
   * Wenn ein Fehler auftritt gebe eine Fehlermeldung aus und terminiere das Programm. 
2. **Output - executeStatement(...)**<br>
   Führe das als String übergebene Statement aus und lese das *QueryResult* ein.
   * Wenn die Anfrage erfolgreich ausgeführt wurde, rufe den Auftrag *putDataInTable* auf.
   * Wenn ein Fehler aufgetreten ist, gebe eine Fehlermeldung in der Konsole aus aber beende NICHT das Programm.
3. **Output - initializeActionListener(...)**<br>
   Die Klasse enthält vier *ActionListeners*. Diese werden ausgelöst wenn einer der Buttons gedrückt wird.
   Implementiere die *actionPerformed()*-Aufträge der jeweiligen Listeners wie unten beschrieben.
   
## Anfragen
### Button1
Ermittelt alle Daten aller Impfzentren und gibt diese in der Tabelle aus.
### Button2
Ermittel wieviele Kunden pro Impfzentrum geimpft werden sollen. Gib die Anzahl der Kunden und den Namen des Impfzentrums aus.
### Button3
Ergänze deine Anfrage aus *Button2* derart, dass zusätzlich die Summe aller an das jeweilige Impfzentrum gelieferten Impfdosen ausgegeben wird.
### Button4
Ergänze deine Anfrage aus *Button3* derart, dass die Anzahl der noch verfügbaren Impfstoffe pro Impfzentrum sowie der Name des jeweiligen Impfzentrums ausgegeben wird. Nutze deine Anfrage aus *Button3* als Untertabelle.
