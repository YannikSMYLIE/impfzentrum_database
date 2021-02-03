# IntelliJ installieren
1. Laden Sie sich die IntelliJ Community Version herunter und installieren Sie diese. Die aktuelle Version finden Sie [hier](https://www.jetbrains.com/de-de/idea/download/). <br>
   <small>Holen Sie sich einen Kaffee, da es ca. 650MB sind, die Sie herunterladen müssen.</small>
2. Installieren Sie IntelliJ.
3. Starten Sie IntelliJ!

# Den Programmrahmen herunterladen
1. Wählen Sie bei dem erscheinenden Splash-Screen "Get from VCS".
2. Geben Sie bei `URL` `git@github.com:YannikSMYLIE/impfzentrum_database.git` ein. 
3. Wählen Sie bei `Directory` den gewünschten Speicherort aus (Sie müssen hier im Regelfall keine Änderung vornehmen). 
4. Klicken Sie auf `Clone` um das Projekt herunterzuladen
    * Eventuell müssen Sie noch GIT installieren. Klicken Sie dazu auf `Download and Install` und warten Sie, bis der Vorgang abgeschlossen ist. Danach sollte der `Clone`-Button klickbar sein.

![download_step1] ![download_step2]

# Den SQL-Treiber einbinden
Um auf die Datenbank zugreifen zu können, wird eine externe Bibliothek verwendet. Diese müssen wir zuerst herunterladen.
1. Klicken Sie [hier](https://dev.mysql.com/downloads/connector/j/) um zur Downloadseite von MySQL zu gelangen.
    * Wählen Sie bei `Select Operating System` `Platform Independent` aus.
    * Laden Sie die `ZIP`-Datei herunter. Wählen Sie im Download-Fenster `No thanks, just start my download.` aus.
    * Entpacken Sie die Datei an einem geeigneten Ort. Sie darf nicht gelöscht werden, da sonst Ihre Projekte nicht mehr funktionieren.
2. Öffnen Sie nun wieder IntelliJ und den Programmrahmen.
3. Klicken Sie im Reiter `Project` mit der rechten Maustaste auf `impzentrum_database` und wählen Sie `Open Module Settings` aus.
4. Wechseln Sie im Fenster zu `Libraries`!!!
5. Klicken Sie auf das `+` und wählen Sie nun die in Schritt 1 heruntergeladene `.jar`-Datei aus.
6. Klicken Sie dann auf `OK`.

![sqldriver_step1] ![sqldriver_step2]

# Erste Schritte
Um das Programm auszuführen müssen Sie **einmalig** mit der rechten Maustaste auf die `Main` Klasse klicken (diese finden Sie unter `src/Main`).<br>
Hier wählen Sie nun `Run Main.main()` aus und das Programm wird erstmalig Kompiliert und ausgeführt.

![run_step1]

Danach können Sie das Programm auch mit dem kleinen grünen Pfeil oben rechts starten.

![run_step2]

# Fehlerbehandlung
* **Ich kann das Programm nicht wie unter `Erste Schritte` erklärt ausführen.**<br>
  Wahrscheinlich ist noch kein JDK installiert. Im rechten Teil der IDE, dort wo der Programmcode steht, sollte eine blaue Leiste mit einer Fehlermeldung erscheinen.<br>
  Hier haben Sie die Möglichkeit das JDK schnell und einfach zu installieren. Eventuell müssen Sie das Programm danach neu starten!
* **Ich erhalte die folgende Fehlermeldung:**<br>`Loading class 'com.mysql.jdbc.Driver'. This is deprecated. The new driver class is 'com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.`<br>
  Diese Fehlermeldung können Sie ignorieren. Sie hat keine Auswirkung auf Ihr Programm.
  

<!-- Images -->
[download_step1]: ./images/download_step1.png
[download_step2]: ./images/download_step2.png
[sqldriver_step1]: ./images/sqldriver_step1.png
[sqldriver_step2]: ./images/sqldriver_step2.png
[run_step1]: ./images/run_step1.png
[run_step2]: ./images/run_step2.png